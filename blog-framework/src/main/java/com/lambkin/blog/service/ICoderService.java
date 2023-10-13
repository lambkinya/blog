package com.lambkin.blog.service;

import com.lambkin.blog.model.domain.CoderEntity;
import com.lambkin.blog.model.CoderInfoVo;
import com.lambkin.blog.model.dto.AdminCoderPageRequest;
import com.lambkin.blog.ya.YaPage;

/**
 * <p>Coder--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
public interface ICoderService {

    CoderEntity queryByNo(String coderNo);

    CoderInfoVo queryInfoByNo(String apiToken);

    YaPage<?> queryCoderPageAdmin(AdminCoderPageRequest dto);
}

