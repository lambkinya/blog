package com.lambkin.blog.web;

import com.lambkin.blog.model.vo.AdminCategoryVo;
import com.lambkin.blog.model.vo.CategoryDetailVo;
import com.lambkin.blog.service.ICategoryService;
import com.lambkin.blog.ya.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>分类表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Resource
    private ICategoryService categoryServiceImpl;


    @GetMapping("/list")
    public ApiResponse<?> queryCategoryList() {
        List<CategoryDetailVo> result = categoryServiceImpl.queryCategoryList();
        return ApiResponse.ok(result);
    }


    @GetMapping("/list-admin")
    public ApiResponse<?> queryCategoryListAdmin() {
        List<AdminCategoryVo> result = categoryServiceImpl.queryCategoryDetailListAdmin();
        return ApiResponse.ok(result);
    }

}

