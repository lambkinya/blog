package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambkin.blog.dao.WeiYanMapper;
import com.lambkin.blog.domain.WeiYanEntity;
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

    public IPage<WeiYanEntity> queryPage(Long current, Long size) {
        return weiYanMapper.selectPage(
                new Page<>(current, size), null
        );
    }
}
