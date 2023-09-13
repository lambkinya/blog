package com.lambkin.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lambkin.blog.domain.CategoryEntity;
import com.lambkin.blog.ya.YaApiResult;

import java.util.List;

/**
 * <p>分类表--Category--service</p>
 *
 * @author lambkinya
 * @since 2023-09-10 10:40:57
 */
public interface ICategoryService {

    /**
     * 查询分类列表
     * @param categoryNo 父分类ID
     * @return YaApiResult<List<CategoryListVo>>
     */
    List<?> queryList(String categoryNo);
}

