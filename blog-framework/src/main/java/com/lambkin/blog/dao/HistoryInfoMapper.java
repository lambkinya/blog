package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.model.domain.HistoryInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>历史信息--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
@Mapper
public interface HistoryInfoMapper extends BaseMapper<HistoryInfoEntity> {

}

