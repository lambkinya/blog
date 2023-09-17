package com.lambkin.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lambkin.blog.domain.ArticleEntity;
import com.lambkin.blog.domain.CategoryEntity;
import com.lambkin.blog.domain.CoderEntity;
import com.lambkin.blog.domain.TagEntity;
import com.lambkin.blog.model.dto.ArticlePageDto;
import com.lambkin.blog.model.vo.ArticleDetailVo;
import com.lambkin.blog.model.vo.ArticlePageVo;
import com.lambkin.blog.model.vo.CategoryVo;
import com.lambkin.blog.model.vo.TagVo;
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

        IPage<ArticleEntity> articleEntityPage = articleQuery.queryArticleByConditionPage(
                dto.getKey(), dto.getCategoryNo(), dto.getCurrent(), dto.getSize()
        );

        List<ArticlePageVo> articleList = articleEntityPage.getRecords().stream().map(
                article -> buildArticleOtherInfo(article, ArticlePageVo.class)
        ).toList();

        return YaPageBean.build(articleEntityPage, articleList);
    }



    @Override
    public ArticleDetailVo queryArticleDetailByNo(String no) {

        ArticleEntity articleEntity = articleQuery.queryDetailByNo(no);

        ArticleDetailVo result = buildArticleOtherInfo(articleEntity, ArticleDetailVo.class);

        CoderEntity coderEntity = coderQuery.queryByCoderNo(articleEntity.getCoderNo());
        result.setCoderName(coderEntity.getUsername());

        return result;
    }



    /**
     * <p>填充该文章关联的分类和标签信息</p>
     * @param entity com.lambkin.blog.domain.ArticleEntity
     * @param clazz com.lambkin.blog.model.vo.ArticleDetailVo | com.lambkin.blog.model.vo.ArticlePageVo
     * @return com.lambkin.blog.model.vo.ArticleDetailVo | com.lambkin.blog.model.vo.ArticlePageVo
     * @param <V> com.lambkin.blog.model.vo.ArticleDetailVo | com.lambkin.blog.model.vo.ArticlePageVo
     */
    private <V> V buildArticleOtherInfo(ArticleEntity entity, Class<V> clazz) {
        Integer commentCount = commentQuery.countArticleComment(entity.getNo());
        CategoryEntity category = categoryQuery.queryByNo(entity.getCategoryNo());
        TagEntity tag = tagQuery.queryByNo(entity.getTagNo());

        V article = (V) YaBeanCopyUtil.copyBean(entity, clazz);

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

