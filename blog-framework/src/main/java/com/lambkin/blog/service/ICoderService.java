package com.lambkin.blog.service;

import com.lambkin.blog.domain.CoderEntity;

/**
 * <p>Coder--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
public interface ICoderService {

    CoderEntity queryByNo(String coderNo);
}

