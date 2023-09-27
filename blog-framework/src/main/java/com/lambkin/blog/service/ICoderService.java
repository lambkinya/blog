package com.lambkin.blog.service;

import com.lambkin.blog.model.domain.CoderEntity;
import com.lambkin.blog.model.CoderInfoVo;
import com.lambkin.blog.model.dto.AdminCoderPageDto;
import com.lambkin.blog.ya.YaPageBean;

/**
 * <p>Coder--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
public interface ICoderService {

    CoderEntity queryByNo(String coderNo);

    CoderInfoVo queryInfoByNo(String apiToken);

    YaPageBean<?> queryCoderPageAdmin(AdminCoderPageDto dto);
}

