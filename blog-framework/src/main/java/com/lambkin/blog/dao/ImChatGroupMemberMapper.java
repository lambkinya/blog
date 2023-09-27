package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.model.domain.ImChatGroupMemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>聊天群成员表--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:26
 */
@Mapper
public interface ImChatGroupMemberMapper extends BaseMapper<ImChatGroupMemberEntity> {

}

