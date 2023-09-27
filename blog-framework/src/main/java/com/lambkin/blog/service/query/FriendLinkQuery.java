package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lambkin.blog.dao.FriendLinkMapper;
import com.lambkin.blog.model.domain.FriendLinkEntity;
import com.lambkin.blog.ya.YaBeanNoUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-19 19:41:52
 */
@Component
public class FriendLinkQuery {

    @Resource
    private FriendLinkMapper friendLinkMapper;


    public List<FriendLinkEntity> queryFriendLinks() {
        return friendLinkMapper.selectList(
                new LambdaQueryWrapper<FriendLinkEntity>().eq(FriendLinkEntity::getStatus, 1)
        );
    }

    public void add(FriendLinkEntity friendLinkEntity) {
        friendLinkEntity.setNo(YaBeanNoUtil.generateNo("FLN"));
        friendLinkMapper.insert(friendLinkEntity);
    }
}
