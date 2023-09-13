package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.service.ICommentService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>评论表--Comment--web</p>
 *
 * @author lambkinya
 * @since 2023-09-14 00:25:58
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private ICommentService commentServiceImpl;

}

