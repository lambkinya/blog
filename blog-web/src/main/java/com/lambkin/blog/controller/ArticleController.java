package com.lambkin.blog.controller;

import com.lambkin.blog.model.dto.article.ArticleAddRequest;
import com.lambkin.blog.service.IArticleService;
import com.lambkin.blog.ya.ApiResponse;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章 - Article
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Resource
    private IArticleService articleServiceImpl;


    /**
     * 保存文章
     */
    @PostMapping("/save")
    public ApiResponse<?> saveArticle(@Valid @RequestBody ArticleAddRequest param) {
        articleServiceImpl.saveArticle(param);
        return ApiResponse.ok();
    }

}
