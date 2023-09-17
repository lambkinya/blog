package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.domain.FriendLinkEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>友链表--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
@Mapper
public interface FriendLinkMapper extends BaseMapper<FriendLinkEntity> {

}

