package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambkin.blog.dao.CoderMapper;
import com.lambkin.blog.model.domain.CoderEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-13 11:20:24
 */
@Component
public class CoderQuery {

    @Resource
    private CoderMapper coderMapper;

    public CoderEntity queryByUsername(String username) {
        return coderMapper.selectOne(
                new LambdaQueryWrapper<CoderEntity>().eq(CoderEntity::getUsername, username)
        );
    }

    public void save(CoderEntity coder) {
        coderMapper.insert(coder);
    }

    public CoderEntity queryByCoderNo(String no) {
        return coderMapper.selectOne(
                new LambdaQueryWrapper<CoderEntity>().eq(CoderEntity::getNo, no)
        );
    }

    public void update(CoderEntity coderEntity) {
        coderMapper.updateById(coderEntity);
    }

    public IPage<CoderEntity> queryCoderPageAdmin(CoderEntity param, Long current, Long size) {
        String username = param.getUsername();
        String phone = param.getPhone();
        Integer status = param.getStatus();
        Integer type = param.getType();

        return coderMapper.selectPage(
                new Page<>(current, size),
                new LambdaQueryWrapper<CoderEntity>()
                        .eq(StringUtils.hasText(phone), CoderEntity::getPhone, phone)
                        .eq(status != null, CoderEntity::getStatus, size)
                        .eq(type != null, CoderEntity::getType, type)
                        .like(StringUtils.hasText(username), CoderEntity::getUsername, username)
        );
    }
}
