package com.lambkin.blog.web;

import com.lambkin.blog.model.dto.AdminCommentPageRequest;
import com.lambkin.blog.model.dto.CommentPageRequest;
import com.lambkin.blog.model.dto.PublishCommentDto;
import com.lambkin.blog.service.ICommentService;
import com.lambkin.blog.ya.ApiResponse;
import com.lambkin.blog.ya.YaPage;
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
    public ApiResponse<?> queryCommentByConditionPage(@RequestBody CommentPageRequest dto) {
        YaPage<?> result = commentServiceImpl.queryCommentByConditionPage(dto);
        return ApiResponse.ok(result);
    }


    @PostMapping("/list-admin")
    public ApiResponse<?> queryCommentByConditionPageAdmin(@RequestBody AdminCommentPageRequest dto) {
        YaPage<?> result = commentServiceImpl.queryCommentByConditionPageAdmin(dto);
        return ApiResponse.ok(result);
    }


    @PostMapping("/publish")
    public ApiResponse<?> publishComment(@RequestBody PublishCommentDto dto) {
        commentServiceImpl.publishComment(dto);
        return ApiResponse.ok();
    }


    @GetMapping("/total")
    public ApiResponse<?> countCommentTotalByArticleNoOrType(String articleNo, Integer type) {
        Integer result = commentServiceImpl.countCommentTotalByArticleNoOrType(articleNo, type);
        return ApiResponse.ok(result);
    }

}

