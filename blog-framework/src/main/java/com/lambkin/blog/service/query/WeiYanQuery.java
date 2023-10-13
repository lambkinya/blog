package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambkin.blog.dao.WeiYanMapper;
import com.lambkin.blog.model.domain.WeiYanEntity;
import com.lambkin.blog.ya.YaBeanUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-24 05:54:09
 */
@Component
public class WeiYanQuery {

    @Resource
    private WeiYanMapper weiYanMapper;

    public IPage<WeiYanEntity> queryPage(String source, Integer type, Long current, Long size) {
        return weiYanMapper.selectPage(
                new Page<>(current, size),
                new LambdaQueryWrapper<WeiYanEntity>()
                        .eq(WeiYanEntity::getCoderNo, source)
                        .eq(WeiYanEntity::getType, type)
        );
    }

    public void save(String coderNo, String content, Boolean isPublic, Integer type) {
        WeiYanEntity weiYanEntity = new WeiYanEntity();
        weiYanEntity.setNo(YaBeanUtils.generateNo("WYN"));
        weiYanEntity.setCoderNo(coderNo);
        weiYanEntity.setContent(content);
        weiYanEntity.setType(type);
        weiYanEntity.setIsPublic(isPublic ? 1 : 0);

        weiYanMapper.insert(weiYanEntity);
    }
}
