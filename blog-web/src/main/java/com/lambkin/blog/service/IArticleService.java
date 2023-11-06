package com.lambkin.blog.service;

import com.lambkin.blog.model.dto.article.ArticleAddRequest;
import com.lambkin.blog.model.entity.ArticleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 文章表 服务类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
public interface IArticleService extends IService<ArticleEntity> {

    /**
     * 添加文章
     *
     * @param req 文章数据
     */
    void saveArticle(ArticleAddRequest req);
}
