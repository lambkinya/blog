package com.lambkin.blog.web;

import com.lambkin.blog.ya.YaApiResult;
import jakarta.annotation.Resource;
import com.lambkin.blog.service.ICategoryService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>分类表--Category--web</p>
 *
 * @author lambkinya
 * @since 2023-09-10 10:40:57
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private ICategoryService categoryServiceImpl;


    @GetMapping("/getCategoryList")
    public YaApiResult<?> getCategoryList(String categoryNo) {
        return YaApiResult.okResult(categoryServiceImpl.queryList(categoryNo));
    }

}

