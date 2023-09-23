package com.lambkin.blog.service.query;

import com.lambkin.blog.dao.SweetheartMapper;
import com.lambkin.blog.domain.SweetheartEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-23 18:04:22
 */
@Component
public class SweetheartQuery {

    @Resource
    private SweetheartMapper sweetheartMapper;


    public SweetheartEntity queryAdminSweetheart() {
        return sweetheartMapper.selectById(1);
    }
}
