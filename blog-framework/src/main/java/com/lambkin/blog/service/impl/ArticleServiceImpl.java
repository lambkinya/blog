package com.lambkin.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lambkin.blog.model.domain.ArticleEntity;
import com.lambkin.blog.model.domain.CategoryEntity;
import com.lambkin.blog.model.domain.CoderEntity;
import com.lambkin.blog.model.domain.TagEntity;
import com.lambkin.blog.model.dto.ArticlePageDto;
import com.lambkin.blog.model.vo.*;
import com.lambkin.blog.service.IArticleService;
import com.lambkin.blog.service.query.*;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import com.lambkin.blog.ya.YaPageBean;
import jakarta.annotation.Resource;
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


    @Override
    public YaPageBean<?> queryArticleByConditionPage(ArticlePageDto dto) {

        IPage<ArticleEntity> pageInfo = articleQuery.queryArticleByConditionPage(
                dto.getKey(), dto.getCategoryNo(), false, dto.getCurrent(), dto.getSize()
        );

        List<ArticlePageVo> articleList = pageInfo.getRecords().stream().map(
                article -> buildArticleOtherInfo(article, ArticlePageVo.class)
        ).toList();

        return YaPageBean.build(pageInfo, articleList);
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
    public YaPageBean<?> queryRecommendArticlePage(Long current, Long size) {
        IPage<ArticleEntity> pageInfo = articleQuery.queryArticleByConditionPage(
                null, null, true, current, size
        );

        List<RecommendArticleVo> recommendArticleVos = pageInfo.getRecords().stream().map(entity -> {
            RecommendArticleVo recommendArticleVo = YaBeanCopyUtil.copyBean(entity, RecommendArticleVo.class);
            CategoryEntity categoryEntity = categoryQuery.queryByNo(entity.getCategoryNo());

            recommendArticleVo.setCategoryName(categoryEntity.getName());

            return recommendArticleVo;
        }).toList();

        return YaPageBean.build(pageInfo, recommendArticleVos);
    }

    @Override
    public YaPageBean<?> queryArticleByConditionPageAdmin(ArticlePageDto dto) {

        IPage<ArticleEntity> pageInfo = articleQuery.queryArticleByConditionPage(
                dto.getKey(), dto.getCategoryNo(), false, dto.getCurrent(), dto.getSize()
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

        return YaPageBean.build(pageInfo, articleList);
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

