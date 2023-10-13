package com.lambkin.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lambkin.blog.model.domain.ArticleEntity;
import com.lambkin.blog.model.domain.CategoryEntity;
import com.lambkin.blog.model.domain.CoderEntity;
import com.lambkin.blog.model.domain.TagEntity;
import com.lambkin.blog.model.dto.ArticleEsDto;
import com.lambkin.blog.model.dto.ArticlePageDto;
import com.lambkin.blog.model.vo.*;
import com.lambkin.blog.service.IArticleService;
import com.lambkin.blog.service.query.*;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import com.lambkin.blog.ya.YaPage;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * <p>文章表--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
@Service("iArticleService")
@Slf4j
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleQuery articleQuery;
    @Resource
    private CategoryQuery categoryQuery;
    @Resource
    private TagQuery tagQuery;
    @Resource
    private CommentQuery commentQuery;
    @Resource
    private CoderQuery coderQuery;
    @Resource
    private ElasticsearchOperations elasticsearchOperations;


    @Override
    public YaPage<?> doSearch(String searchText, long pageNum, long pageSize) {
        // es 起始页为 0
        long current = pageNum - 1;
        NativeQuery nativeQuery = NativeQuery.builder()
                .withQuery(q -> q
                        .match(m -> m
                                .field("title")
                                .query(searchText)
                        )
                )
                .withFilter(q -> q
                        .term(t -> t
                                .field("yn")
                                .value(0)
                        )
                )
                .build();
        SearchHits<ArticleEsDto> searchHits = elasticsearchOperations.search(nativeQuery, ArticleEsDto.class);

        List<String> articleNoList = searchHits.getSearchHits().stream().map(item -> item.getContent().getNo()).toList();
        List<ArticleEntity> articleEntityList = articleQuery.queryByNos(articleNoList);
        List<ArticlePageVo> articlePageVoList = YaBeanCopyUtil.copyBeanList(articleEntityList, ArticlePageVo.class);

        YaPage<ArticlePageVo> result = new YaPage<>();
        result.setRecords(articlePageVoList);
        result.setTotal(searchHits.getTotalHits());
        result.setCurrent(pageNum);
        result.setSize(pageSize);

        return result;
    }

    @Override
    public YaPage<?> queryArticleByConditionPage(ArticlePageDto dto) {

        IPage<ArticleEntity> pageInfo = articleQuery.queryArticleByConditionPage(
                dto.getKey(), dto.getCategoryNo(), dto.getTagNo(), false, dto.getCurrent(), dto.getSize()
        );

        List<ArticlePageVo> articleList = pageInfo.getRecords().stream().map(
                article -> buildArticleOtherInfo(article, ArticlePageVo.class)
        ).toList();

        return YaPage.build(pageInfo, articleList);
    }

    @Override
    public ArticleDetailVo queryArticleDetailByNo(String no) {

        ArticleEntity articleEntity = articleQuery.queryDetailByNo(no);

        ArticleDetailVo result = buildArticleOtherInfo(articleEntity, ArticleDetailVo.class);

        CoderEntity coderEntity = coderQuery.queryByCoderNo(articleEntity.getCoderNo());
        result.setCoderName(coderEntity.getUsername());

        return result;
    }

    @Override
    public YaPage<?> queryRecommendArticlePage(Long current, Long size) {
        IPage<ArticleEntity> pageInfo = articleQuery.queryArticleByConditionPage(
                null, null, null, true, current, size
        );

        List<RecommendArticleVo> recommendArticleVos = pageInfo.getRecords().stream().map(entity -> {
            RecommendArticleVo recommendArticleVo = YaBeanCopyUtil.copyBean(entity, RecommendArticleVo.class);
            CategoryEntity categoryEntity = categoryQuery.queryByNo(entity.getCategoryNo());

            recommendArticleVo.setCategoryName(categoryEntity.getName());

            return recommendArticleVo;
        }).toList();

        return YaPage.build(pageInfo, recommendArticleVos);
    }

    @Override
    public YaPage<?> queryArticleByConditionPageAdmin(ArticlePageDto dto) {

        IPage<ArticleEntity> pageInfo = articleQuery.queryArticleByConditionPage(
                dto.getKey(), dto.getCategoryNo(), null, false, dto.getCurrent(), dto.getSize()
        );

        List<AdminArticlePageVo> articleList = pageInfo.getRecords().stream().map(entity -> {
            AdminArticlePageVo vo = YaBeanCopyUtil.copyBean(entity, AdminArticlePageVo.class);

            CoderEntity coderEntity = coderQuery.queryByCoderNo(entity.getCoderNo());
            CategoryEntity categoryEntity = categoryQuery.queryByNo(entity.getCategoryNo());
            TagEntity tagEntity = tagQuery.queryByNo(entity.getTagNo());
            Integer commentCount = commentQuery.countCommentTotalByArticleNoOrType(entity.getNo(), null);

            vo.setCoderName(coderEntity.getUsername());
            vo.setCategoryName(categoryEntity.getName());
            vo.setTagName(tagEntity.getName());
            vo.setCommentCount(commentCount);

            return vo;
        }).toList();

        return YaPage.build(pageInfo, articleList);
    }

    @Override
    public List<ArticleEntity> searchAllInner() {
        return articleQuery.queryList();
    }

    /**
     * <p>填充该文章关联的分类和标签信息</p>
     *
     * @param entity com.lambkin.blog.domain.ArticleEntity
     * @param clazz  com.lambkin.blog.model.vo.ArticleDetailVo | com.lambkin.blog.model.vo.ArticlePageVo
     * @param <V>    com.lambkin.blog.model.vo.ArticleDetailVo | com.lambkin.blog.model.vo.ArticlePageVo
     * @return com.lambkin.blog.model.vo.ArticleDetailVo | com.lambkin.blog.model.vo.ArticlePageVo
     */
    private <V> V buildArticleOtherInfo(ArticleEntity entity, Class<V> clazz) {
        Integer commentCount = commentQuery.countCommentTotalByArticleNoOrType(entity.getNo(), null);
        CategoryEntity category = categoryQuery.queryByNo(entity.getCategoryNo());
        TagEntity tag = tagQuery.queryByNo(entity.getTagNo());

        V article = YaBeanCopyUtil.copyBean(entity, clazz);

        try {
            Method setCategoryInfo = clazz.getDeclaredMethod("setCategoryInfo", CategoryVo.class);
            Method setTagInfo = clazz.getDeclaredMethod("setTagInfo", TagVo.class);
            Method setCommentCount = clazz.getDeclaredMethod("setCommentCount", Integer.class);

            setCategoryInfo.invoke(article, YaBeanCopyUtil.copyBean(category, CategoryVo.class));
            setTagInfo.invoke(article, YaBeanCopyUtil.copyBean(tag, TagVo.class));
            setCommentCount.invoke(article, commentCount);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return article;
    }


}

