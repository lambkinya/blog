package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.domain.TagEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>标签--Tag--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-14 20:49:26
 */
@Mapper
public interface TagMapper extends BaseMapper<TagEntity> {

}

