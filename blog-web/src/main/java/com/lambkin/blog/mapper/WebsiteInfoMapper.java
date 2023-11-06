package com.lambkin.blog.mapper;

import com.lambkin.blog.model.entity.WebsiteInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 网站信息表 Mapper 接口
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Mapper
public interface WebsiteInfoMapper extends BaseMapper<WebsiteInfoEntity> {

}
