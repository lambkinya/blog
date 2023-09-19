package com.lambkin.blog.service.impl;

import com.lambkin.blog.domain.FriendLinkEntity;
import com.lambkin.blog.model.dto.ApplyFriendLinkDto;
import com.lambkin.blog.model.vo.FriendLinkVo;
import com.lambkin.blog.service.IFriendLinkService;
import com.lambkin.blog.service.query.FriendLinkQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>友链表--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
@Service("iFriendLinkService")
public class FriendLinkServiceImpl implements IFriendLinkService {

    @Resource
    private FriendLinkQuery friendLinkQuery;


    @Override
    public List<FriendLinkVo> queryFriendLinks() {
        List<FriendLinkEntity> friendLinkEntityList = friendLinkQuery.queryFriendLinks();
        return YaBeanCopyUtil.copyBeanList(friendLinkEntityList, FriendLinkVo.class);
    }

    @Override
    public void applyFriendLink(ApplyFriendLinkDto dto) {
        friendLinkQuery.add(YaBeanCopyUtil.copyBean(dto, FriendLinkEntity.class));
    }
}

