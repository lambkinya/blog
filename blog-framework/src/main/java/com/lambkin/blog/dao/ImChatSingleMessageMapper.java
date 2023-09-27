package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.model.domain.ImChatSingleMessageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>单聊记录表--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:26
 */
@Mapper
public interface ImChatSingleMessageMapper extends BaseMapper<ImChatSingleMessageEntity> {

}

