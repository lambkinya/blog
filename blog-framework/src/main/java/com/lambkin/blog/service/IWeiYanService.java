package com.lambkin.blog.service;

import com.lambkin.blog.ya.YaPageBean;

/**
 * <p>微言表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:28
 */
public interface IWeiYanService {

    YaPageBean<?> queryPage(Long current, Long size);
}

