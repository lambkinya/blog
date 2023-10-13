package com.lambkin.blog.service;

import com.lambkin.blog.ya.YaPage;

/**
 * <p>微言表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:28
 */
public interface IWeiYanService {

    YaPage<?> queryPage(String source, Integer type, Long current, Long size);

    void publish(String coderNo, String content, Boolean isPublic, Integer type);
}

