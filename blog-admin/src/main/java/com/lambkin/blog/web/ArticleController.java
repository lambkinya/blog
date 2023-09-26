package com.lambkin.blog.web;

import com.lambkin.blog.model.dto.ArticlePageDto;
import com.lambkin.blog.service.IArticleService;
import com.lambkin.blog.ya.YaApiResult;
import com.lambkin.blog.ya.YaPageBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * <p>文章表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Resource
    private IArticleService articleServiceImpl;


    @PostMapping("/list")
    public YaApiResult<?> queryArticlePage(@RequestBody ArticlePageDto dto) {
        YaPageBean<?> result = articleServiceImpl.queryArticleByConditionPageAdmin(dto);
        return YaApiResult.ok(result);
    }

}

