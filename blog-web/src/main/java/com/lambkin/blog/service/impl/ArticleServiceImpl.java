package com.lambkin.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambkin.blog.mapper.ArticleMapper;
import com.lambkin.blog.model.dto.article.ArticleAddRequest;
import com.lambkin.blog.model.entity.ArticleEntity;
import com.lambkin.blog.service.IArticleService;
import com.lambkin.blog.ya.AppErrorCode;
import com.lambkin.blog.ya.ThrowUtils;
import com.lambkin.blog.ya.YaBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 文章表 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements IArticleService {

    @Override
    public void saveArticle(ArticleAddRequest req) {

        ThrowUtils.throwIf(req.getViewStatus() != null && !req.getViewStatus() && !StringUtils.hasText(req.getPassword()),  AppErrorCode.PARAMS_ERROR,  "请设置文章密码");

        ArticleEntity article = new ArticleEntity(YaBeanUtils.generateNo("AN"));
        if (StringUtils.hasText(req.getCover())) {
            article.setCover(req.getCover());
        }
        if (req.getViewStatus() != null && !req.getViewStatus() && StringUtils.hasText(req.getPassword())) {
            article.setPassword(req.getPassword());
            article.setTips(req.getTips());
        }
        article.setViewStatus(req.getViewStatus());
        article.setCommentStatus(req.getCommentStatus());
        article.setRecommendStatus(req.getRecommendStatus());
        article.setTitle(req.getTitle());
        article.setContent(req.getContent());
        article.setCategoryNo(req.getCategoryNo());
        article.setLabelNo(req.getLabelNo());
        article.setCoderNo(req.getCoderNo());
        this.save(article);
    }
}
