package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.service.IArticleTagService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>文章标签关联表--ArticleTag--web</p>
 *
 * @author lambkinya
 * @since 2023-09-14 20:49:26
 */
@RestController
@RequestMapping("/articleTag")
public class ArticleTagController {

    @Resource
    private IArticleTagService articleTagServiceImpl;

}

