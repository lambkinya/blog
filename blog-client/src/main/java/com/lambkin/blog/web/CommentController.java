package com.lambkin.blog.web;

import com.lambkin.blog.model.dto.AdminCommentPageDto;
import com.lambkin.blog.model.dto.CommentPageDto;
import com.lambkin.blog.model.dto.PublishCommentDto;
import com.lambkin.blog.service.ICommentService;
import com.lambkin.blog.ya.YaApiResult;
import com.lambkin.blog.ya.YaPageBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * <p>评论表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Resource
    private ICommentService commentServiceImpl;


    @PostMapping("/list")
    public YaApiResult<?> queryCommentByConditionPage(@RequestBody CommentPageDto dto) {
        YaPageBean<?> result = commentServiceImpl.queryCommentByConditionPage(dto);
        return YaApiResult.ok(result);
    }


    @PostMapping("/list-admin")
    public YaApiResult<?> queryCommentByConditionPageAdmin(@RequestBody AdminCommentPageDto dto) {
        YaPageBean<?> result = commentServiceImpl.queryCommentByConditionPageAdmin(dto);
        return YaApiResult.ok(result);
    }


    @PostMapping("/publish")
    public YaApiResult<?> publishComment(@RequestBody PublishCommentDto dto) {
        commentServiceImpl.publishComment(dto);
        return YaApiResult.ok();
    }


    @GetMapping("/total")
    public YaApiResult<?> countCommentTotalByArticleNoOrType(String articleNo, Integer type) {
        Integer result = commentServiceImpl.countCommentTotalByArticleNoOrType(articleNo, type);
        return YaApiResult.ok(result);
    }

}

