package com.lambkin.blog.web;

import com.lambkin.blog.ya.YaPageBean;
import com.lambkin.blog.ya.YaApiResult;
import jakarta.annotation.Resource;
import com.lambkin.blog.service.IArticleService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>文章表--Article</p>
 *
 * @author lambkinya
 * @since 2023-09-10 04:04:50
 */
@RestController
@RequestMapping("/articles")
public class ArticleEntityController {

    @Resource
    private IArticleService articleServiceImpl;


    @GetMapping("/hotArticleList")
    public YaApiResult<?> queryHotArticleList() {
        return articleServiceImpl.queryHotArticleList();
    }

    @GetMapping("/{no}")
    public YaApiResult<?> queryDetail(@PathVariable("no") String no) {
        return YaApiResult.okResult(articleServiceImpl.queryDetailByNo(no));
    }

    @GetMapping("/page")
    public YaApiResult<?> queryPage(Integer pageNo, Integer pageSize, String categoryNo) {
        YaPageBean<?> result = articleServiceImpl.queryPage(pageNo, pageSize, categoryNo);
        return YaApiResult.okResult(result);
    }

    @GetMapping("/list-desc")
    public YaApiResult<?> queryDesc(Integer pageNo, Integer pageSize) {
        YaPageBean<?> result = articleServiceImpl.queryDesc(pageNo, pageSize);
        return YaApiResult.okResult(result);
    }
}

