package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.model.domain.ImChatGroupMessageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>群聊记录表--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:26
 */
@Mapper
public interface ImChatGroupMessageMapper extends BaseMapper<ImChatGroupMessageEntity> {

}

