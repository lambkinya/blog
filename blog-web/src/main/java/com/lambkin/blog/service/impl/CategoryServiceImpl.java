package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.entity.CategoryEntity;
import com.lambkin.blog.mapper.CategoryMapper;
import com.lambkin.blog.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 分类表 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements ICategoryService {

}
