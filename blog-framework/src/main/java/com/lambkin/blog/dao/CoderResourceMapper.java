package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.domain.CoderResourceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>coder资源信息表--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
@Mapper
public interface CoderResourceMapper extends BaseMapper<CoderResourceEntity> {

}

