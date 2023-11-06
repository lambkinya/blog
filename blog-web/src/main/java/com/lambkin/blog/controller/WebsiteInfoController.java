package com.lambkin.blog.controller;

import com.lambkin.blog.service.IWebsiteInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网站信息表 前端控制器
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/website_info")
public class WebsiteInfoController {

    @Resource
    private IWebsiteInfoService websiteInfoServiceImpl;



}
