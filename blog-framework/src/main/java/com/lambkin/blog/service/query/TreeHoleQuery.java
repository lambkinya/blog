package com.lambkin.blog.service.query;

import com.lambkin.blog.dao.TreeHoleMapper;
import com.lambkin.blog.model.domain.TreeHoleEntity;
import com.lambkin.blog.ya.YaBeanNoUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-23 16:58:43
 */
@Component
public class TreeHoleQuery {

    @Resource
    private TreeHoleMapper treeHoleMapper;


    public List<TreeHoleEntity> queryAllMessage() {
        return treeHoleMapper.selectList(null);
    }

    public TreeHoleEntity add(String message, String avatar) {
        TreeHoleEntity entity = new TreeHoleEntity();
        entity.setNo(YaBeanNoUtil.generateNo("THN"));
        entity.setAvatar(avatar);
        entity.setMessage(message);
        treeHoleMapper.insert(entity);
        return entity;
    }
}
