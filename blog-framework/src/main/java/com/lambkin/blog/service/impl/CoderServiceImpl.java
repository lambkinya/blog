package com.lambkin.blog.service.impl;

import com.lambkin.blog.domain.CoderEntity;
import com.lambkin.blog.service.ICoderService;
import com.lambkin.blog.service.query.CoderQuery;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>Coder--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
@Service("iCoderService")
public class CoderServiceImpl implements ICoderService {

    @Resource
    private CoderQuery coderQuery;


    @Override
    public CoderEntity queryByNo(String coderNo) {
        return coderQuery.queryByCoderNo(coderNo);
    }
}

