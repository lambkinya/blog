package com.lambkin.blog.controller;

import com.lambkin.blog.service.ICommentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论表 前端控制器
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private ICommentService commentServiceImpl;



}
