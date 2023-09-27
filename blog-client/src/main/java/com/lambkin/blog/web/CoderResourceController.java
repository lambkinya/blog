package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.service.ICoderResourceService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>coder资源信息表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/coderResources")
public class CoderResourceController {

    @Resource
    private ICoderResourceService coderResourceServiceImpl;

}

