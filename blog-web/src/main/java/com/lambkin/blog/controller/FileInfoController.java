package com.lambkin.blog.controller;

import com.lambkin.blog.service.IFileInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * coder资源信息表 前端控制器
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/file_info")
public class FileInfoController {

    @Resource
    private IFileInfoService fileInfoServiceImpl;



}
