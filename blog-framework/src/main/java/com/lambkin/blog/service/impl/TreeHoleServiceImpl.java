package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.domain.TreeHoleEntity;
import com.lambkin.blog.model.vo.TreeHoleVo;
import com.lambkin.blog.service.ITreeHoleService;
import com.lambkin.blog.service.query.TreeHoleQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>树洞表--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:27
 */
@Service("iTreeHoleService")
public class TreeHoleServiceImpl implements ITreeHoleService {

    @Resource
    private TreeHoleQuery treeHoleQuery;


    @Override
    public List<TreeHoleVo> queryAllMessage() {
        List<TreeHoleEntity> pageInfo = treeHoleQuery.queryAllMessage();
        return pageInfo.stream().map(treeHoleEntity -> YaBeanCopyUtil.copyBean(treeHoleEntity ,TreeHoleVo.class)).toList();
    }

    @Override
    public TreeHoleVo leaveMessage(String message, String avatar) {
        TreeHoleEntity entity = treeHoleQuery.add(message, avatar);
        return YaBeanCopyUtil.copyBean(entity, TreeHoleVo.class);
    }
}

