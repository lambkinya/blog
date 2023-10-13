package com.lambkin.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lambkin.blog.model.domain.CoderEntity;
import com.lambkin.blog.model.CoderInfoVo;
import com.lambkin.blog.model.dto.AdminCoderPageRequest;
import com.lambkin.blog.model.vo.AdminCoderPageVo;
import com.lambkin.blog.service.ICoderService;
import com.lambkin.blog.service.query.CoderQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import com.lambkin.blog.ya.YaJwtUtil;
import com.lambkin.blog.ya.YaPage;
import io.jsonwebtoken.Claims;
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

    @Override
    public CoderInfoVo queryInfoByNo(String apiToken) {

        String token = apiToken.trim().substring("Beaner".length());

        Claims claims = null;
        try {
            claims = YaJwtUtil.parse(token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String coderNo = claims.getSubject();

        CoderEntity coderEntity = coderQuery.queryByCoderNo(coderNo);

        return YaBeanCopyUtil.copyBean(coderEntity, CoderInfoVo.class);
    }

    @Override
    public YaPage<?> queryCoderPageAdmin(AdminCoderPageRequest dto) {
        CoderEntity param = YaBeanCopyUtil.copyBean(dto, CoderEntity.class);
        param.setUsername(dto.getSearchKey());
        param.setPhone(dto.getSearchKey());
        IPage<CoderEntity> pageInfo = coderQuery.queryCoderPageAdmin(param, dto.getCurrent(), dto.getSize());

        return YaPage.build(pageInfo, AdminCoderPageVo.class);
    }
}

