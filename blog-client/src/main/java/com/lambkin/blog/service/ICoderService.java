package com.lambkin.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lambkin.blog.domain.CoderEntity;

/**
 * <p>Coder--Coder--service</p>
 *
 * @author lambkinya
 * @since 2023-09-13 11:17:14
 */
public interface ICoderService {

    CoderEntity queryByAccount(String account);

    CoderEntity queryByNo(String no);
}

