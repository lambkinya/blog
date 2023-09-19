package com.lambkin.blog.service;

import com.lambkin.blog.model.dto.ApplyFriendLinkDto;
import com.lambkin.blog.model.vo.FriendLinkVo;

import java.util.List;

/**
 * <p>友链表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
public interface IFriendLinkService {

    List<FriendLinkVo> queryFriendLinks();

    void applyFriendLink(ApplyFriendLinkDto dto);
}

