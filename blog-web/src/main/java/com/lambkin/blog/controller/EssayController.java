package com.lambkin.blog.controller;

import com.lambkin.blog.service.IEssayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 随笔表 前端控制器
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/essay")
public class EssayController {

    @Resource
    private IEssayService essayServiceImpl;



}
