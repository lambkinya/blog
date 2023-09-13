package com.lambkin.blog.service.impl;

import com.lambkin.blog.domain.ArticleEntity;
import com.lambkin.blog.domain.CategoryEntity;
import com.lambkin.blog.model.ArticleDetailVo;
import com.lambkin.blog.model.HotArticleListVo;
import com.lambkin.blog.service.IArticleService;
import com.lambkin.blog.service.query.ArticleQuery;
import com.lambkin.blog.service.query.CategoryQuery;
import com.lambkin.blog.ya.YaPageBean;
import com.lambkin.blog.ya.YaApiResult;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>文章表--Article</p>
 *
 * @author lambkinya
 * @since 2023-09-10 03:57:14
 */
@Service("iArticleService")
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleQuery articleQuery;
    @Resource
    private CategoryQuery categoryQuery;

    @Override
    public ArticleDetailVo queryDetailByNo(String no) {
        ArticleEntity articleEntity = articleQuery.queryDetailByNo(no);

        CategoryEntity categoryEntity = categoryQuery.queryByNo(articleEntity.getCategoryNo());

        ArticleDetailVo result = YaBeanCopyUtil.copyBean(articleEntity, ArticleDetailVo.class);

        result.setCategoryName(categoryEntity.getName());

        return result;
    }

    @Override
    public YaApiResult<?> queryHotArticleList() {
        List<ArticleEntity> articleEntities = articleQuery.queryList();
        List<HotArticleListVo> result = YaBeanCopyUtil.copyBeanList(articleEntities, HotArticleListVo.class);
        return YaApiResult.okResult(result);
    }

    @Override
    public YaPageBean<?> queryPage(Integer pageNo, Integer pageSize, String categoryNo) {
        YaPageBean<?> result = articleQuery.queryPage(pageNo, pageSize, categoryNo);

        return result;
    }

    @Override
    public YaPageBean<?> queryDesc(Integer pageNo, Integer pageSize) {
        return articleQuery.queryDesc(pageNo, pageSize);
    }
}

