package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.domain.WebsiteInfoEntity;
import com.lambkin.blog.model.vo.WebsiteInfoVo;
import com.lambkin.blog.service.IWebsiteInfoService;
import com.lambkin.blog.service.query.WebsiteInfoQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>网站信息表--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 15:05:57
 */
@Service("iWebsiteInfoService")
public class WebsiteInfoServiceImpl implements IWebsiteInfoService {

    @Resource
    private WebsiteInfoQuery websiteInfoQuery;


    @Override
    public WebsiteInfoVo queryWebsiteInfo() {
        WebsiteInfoEntity entity = websiteInfoQuery.queryWebsiteInfo();
        return YaBeanCopyUtil.copyBean(entity, WebsiteInfoVo.class);
    }
}

