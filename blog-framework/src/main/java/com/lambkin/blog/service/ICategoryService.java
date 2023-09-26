package com.lambkin.blog.service;

import com.lambkin.blog.model.vo.AdminCategoryVo;
import com.lambkin.blog.model.vo.CategoryDetailVo;
import com.lambkin.blog.model.vo.CategoryVo;

import java.util.List;

/**
 * <p>分类表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
public interface ICategoryService {

    List<CategoryDetailVo> queryCategoryList();

    List<CategoryVo> queryCategoryListAdmin();

    List<AdminCategoryVo> queryCategoryDetailListAdmin();
}

