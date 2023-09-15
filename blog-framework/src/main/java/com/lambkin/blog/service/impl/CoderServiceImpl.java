package com.lambkin.blog.service.impl;

import com.lambkin.blog.domain.CoderEntity;
import com.lambkin.blog.model.dto.CoderSimpleInfoDto;
import com.lambkin.blog.service.ICoderService;
import com.lambkin.blog.service.query.CoderQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>Coder--Coder--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-13 11:17:14
 */
@Service("iCoderService")
public class CoderServiceImpl implements ICoderService {

    @Resource
    private CoderQuery coderQuery;


    @Override
    public CoderEntity queryByAccount(String account) {
        return coderQuery.queryByAccount(account);
    }

    @Override
    public CoderEntity queryByNo(String no) {
        return coderQuery.queryByCoderNo(no);
    }

    @Override
    public void updateCoderSimpleInfo(CoderSimpleInfoDto dto) {
        CoderEntity coderEntity = coderQuery.queryByCoderNo(dto.getNo());
        BeanUtils.copyProperties(dto, coderEntity);
        coderQuery.update(coderEntity);
    }
}

