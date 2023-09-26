package com.lambkin.blog.service;

import com.lambkin.blog.model.dto.ArticlePageDto;
import com.lambkin.blog.model.vo.ArticleDetailVo;
import com.lambkin.blog.ya.YaPageBean;

/**
 * <p>文章表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
public interface IArticleService {

    YaPageBean<?> queryArticleByConditionPage(ArticlePageDto dto);

    ArticleDetailVo queryArticleDetailByNo(String no);

    YaPageBean<?> queryRecommendArticlePage(Long current, Long size);

    YaPageBean<?> queryArticleByConditionPageAdmin(ArticlePageDto dto);
}

