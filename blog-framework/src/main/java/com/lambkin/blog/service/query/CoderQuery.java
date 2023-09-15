package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lambkin.blog.dao.CoderMapper;
import com.lambkin.blog.domain.CoderEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

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

    public CoderEntity queryByAccount(String account) {
        return coderMapper.selectOne(
                new LambdaQueryWrapper<CoderEntity>().eq(CoderEntity::getAccount, account)
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
}
