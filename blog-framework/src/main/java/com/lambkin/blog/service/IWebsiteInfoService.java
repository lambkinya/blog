package com.lambkin.blog.service;

import com.lambkin.blog.model.vo.WebsiteInfoVo;

/**
 * <p>网站信息表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 15:05:57
 */
public interface IWebsiteInfoService {

    /**
     * 查询网站配置信息
     * @return com.lambkin.blog.model.vo.WebsiteInfoVo
     */
    WebsiteInfoVo queryWebsiteInfo();
}

