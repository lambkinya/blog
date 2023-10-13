package com.lambkin.blog.service;

import com.lambkin.blog.model.domain.ArticleEntity;
import com.lambkin.blog.model.dto.ArticlePageDto;
import com.lambkin.blog.model.vo.ArticleDetailVo;
import com.lambkin.blog.ya.YaPage;

import java.util.List;

/**
 * <p>文章表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
public interface IArticleService {

    YaPage<?> queryArticleByConditionPage(ArticlePageDto dto);

    ArticleDetailVo queryArticleDetailByNo(String no);

    YaPage<?> queryRecommendArticlePage(Long current, Long size);

    YaPage<?> queryArticleByConditionPageAdmin(ArticlePageDto dto);

    /**
     * 搜索
     *
     * @param searchText 搜索关键字
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return com.lambkin.so.ya.YaPage
     */
    YaPage<?> doSearch(String searchText, long pageNum, long pageSize);

    List<ArticleEntity> searchAllInner();
}

