package com.lambkin.blog.service.impl;

import com.lambkin.blog.domain.SweetheartEntity;
import com.lambkin.blog.model.vo.SweetheartVo;
import com.lambkin.blog.service.ISweetheartService;
import com.lambkin.blog.service.query.SweetheartQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>恋人表--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:27
 */
@Service("iSweetheartService")
public class SweetheartServiceImpl implements ISweetheartService {

    @Resource
    private SweetheartQuery sweetheartQuery;


    @Override
    public SweetheartVo queryAdminSweetheart() {
        SweetheartEntity entity = sweetheartQuery.queryAdminSweetheart();
        return YaBeanCopyUtil.copyBean(entity, SweetheartVo.class);
    }
}

