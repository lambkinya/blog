package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.domain.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>分类表--Category--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-10 10:40:57
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {

}

