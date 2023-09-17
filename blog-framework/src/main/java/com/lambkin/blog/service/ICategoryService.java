package com.lambkin.blog.service;

import com.lambkin.blog.model.vo.CategoryDetailVo;

import java.util.List;

/**
 * <p>分类表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
public interface ICategoryService {

    List<CategoryDetailVo> queryCategoryList();
}

