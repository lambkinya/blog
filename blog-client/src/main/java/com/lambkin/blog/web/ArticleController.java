package com.lambkin.blog.web;

import com.lambkin.blog.model.dto.ArticlePageDto;
import com.lambkin.blog.model.vo.ArticleDetailVo;
import com.lambkin.blog.service.IArticleService;
import com.lambkin.blog.ya.YaApiResult;
import com.lambkin.blog.ya.YaBasePageDto;
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
    public YaApiResult<?> queryArticleByConditionPage(@RequestBody ArticlePageDto dto) {
        YaPageBean<?> result = articleServiceImpl.queryArticleByConditionPage(dto);
        return YaApiResult.ok(result);
    }


    @GetMapping("/detail")
    public YaApiResult<?> queryArticleDetailByNo(String no) {
        ArticleDetailVo result = articleServiceImpl.queryArticleDetailByNo(no);
        return YaApiResult.ok(result);
    }


    @PostMapping("/recommend")
    public YaApiResult<?> queryRecommendArticlePage(@RequestBody YaBasePageDto dto) {
        YaPageBean<?> result = articleServiceImpl.queryRecommendArticlePage(dto.getCurrent(), dto.getSize());
        return YaApiResult.ok(result);
    }

}

