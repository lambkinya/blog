package com.lambkin.blog.web;

import com.lambkin.blog.domain.ArticleEntity;
import jakarta.annotation.Resource;
import com.lambkin.blog.service.IArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>文章表--Article</p>
 *
 * @author lambkinya
 * @since 2023-09-10 04:04:50
 */
@RestController
@RequestMapping("/article")
public class ArticleEntityController {

    @Resource
    private IArticleService articleServiceImpl;


    @GetMapping("/list")
    public String test() {
        List<ArticleEntity> articleEntities = articleServiceImpl.getBaseMapper().selectList(null);
        return articleEntities.toString();
    }
}

