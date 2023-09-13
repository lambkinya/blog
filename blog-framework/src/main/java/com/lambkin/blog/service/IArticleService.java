package com.lambkin.blog.service;

import com.lambkin.blog.model.ArticleDetailVo;
import com.lambkin.blog.ya.YaPageBean;
import com.lambkin.blog.ya.YaApiResult;

/**
 * <p>文章表--Article</p>
 *
 * @author lambkinya
 * @since 2023-09-10 03:50:49
 */
public interface IArticleService {

    /**
     * 文章详情
     * @param no 文章编号
     * @return ArticleDetailVo
     */
    ArticleDetailVo queryDetailByNo(String no);

    /**
     * 查询热门文章
     * @return
     */
    YaApiResult<?> queryHotArticleList();

    YaPageBean<?> queryPage(Integer pageNo, Integer pageSize, String categoryNo);

    YaPageBean<?> queryDesc(Integer pageNo, Integer pageSize);
}

