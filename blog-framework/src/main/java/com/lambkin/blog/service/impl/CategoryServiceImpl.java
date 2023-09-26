package com.lambkin.blog.service.impl;

import com.lambkin.blog.domain.CategoryEntity;
import com.lambkin.blog.domain.TagEntity;
import com.lambkin.blog.model.vo.AdminCategoryVo;
import com.lambkin.blog.model.vo.CategoryDetailVo;
import com.lambkin.blog.model.vo.CategoryVo;
import com.lambkin.blog.model.vo.TagDetailVo;
import com.lambkin.blog.service.ICategoryService;
import com.lambkin.blog.service.query.ArticleQuery;
import com.lambkin.blog.service.query.CategoryQuery;
import com.lambkin.blog.service.query.TagQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>分类表--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryQuery categoryQuery;
    @Resource
    private TagQuery tagQuery;
    @Resource
    private ArticleQuery articleQuery;


    @Override
    public List<CategoryDetailVo> queryCategoryList() {
        List<CategoryEntity> categoryEntityList = categoryQuery.queryList();

        return categoryEntityList.stream().map(categoryEntity -> {
            CategoryDetailVo category = YaBeanCopyUtil.copyBean(categoryEntity, CategoryDetailVo.class);

            Integer categoryArticleCount = articleQuery.countCategoryArticle(category.getNo());
            List<TagEntity> tagEntity = tagQuery.queryListByCategoryNo(category.getNo());

            List<TagDetailVo> tagInfoList = tagEntity.stream().map(tagItem -> {
                TagDetailVo tag = YaBeanCopyUtil.copyBean(tagItem, TagDetailVo.class);

                Integer tagArticleCount = articleQuery.countTagArticle(tagItem.getNo());

                tag.setArticleCount(tagArticleCount);

                return tag;
            }).toList();


            category.setTagInfoList(tagInfoList);
            category.setArticleCount(categoryArticleCount);

            return category;
        }).toList();
    }

    @Override
    public List<CategoryVo> queryCategoryListAdmin() {
        List<CategoryEntity> categoryEntityList = categoryQuery.queryList();

        return YaBeanCopyUtil.copyBeanList(categoryEntityList, CategoryVo.class);
    }

    @Override
    public List<AdminCategoryVo> queryCategoryDetailListAdmin() {
        List<CategoryEntity> categoryEntityList = categoryQuery.queryList();

        return categoryEntityList.stream().map(entity -> {
            AdminCategoryVo vo = YaBeanCopyUtil.copyBean(entity, AdminCategoryVo.class);

            Integer articleCount = articleQuery.countCategoryArticle(entity.getNo());
            vo.setArticleCount(articleCount);

            return vo;
        }).toList();
    }
}

