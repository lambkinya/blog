package com.lambkin.blog.web;

import com.lambkin.blog.model.vo.WebsiteInfoVo;
import com.lambkin.blog.service.IWebsiteInfoService;
import com.lambkin.blog.service.query.WebsiteInfoQuery;
import com.lambkin.blog.ya.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>网站信息表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 15:05:11
 */
@RestController
@RequestMapping("/websiteInfos")
public class WebsiteInfoController {

    @Resource
    private IWebsiteInfoService websiteInfoServiceImpl;
    @Resource
    private WebsiteInfoQuery websiteInfoQuery;


    @GetMapping("/getWebsiteInfo")
    private ApiResponse<?> queryWebsiteInfo() {
        WebsiteInfoVo result = websiteInfoServiceImpl.queryWebsiteInfo();
        return ApiResponse.ok(result);
    }

    @GetMapping("/wai-fu-json")
    private String queryWaiFuJson() {
        return websiteInfoQuery.queryWaiFuJson();
    }

}

