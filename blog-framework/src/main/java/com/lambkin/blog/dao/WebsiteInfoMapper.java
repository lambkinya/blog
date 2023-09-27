package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.model.domain.WebsiteInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>网站信息表--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-17 15:05:57
 */
@Mapper
public interface WebsiteInfoMapper extends BaseMapper<WebsiteInfoEntity> {

}

