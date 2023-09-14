package com.lambkin.blog.web;

import com.lambkin.blog.model.CommentVo;
import com.lambkin.blog.model.dto.AddCommentDto;
import com.lambkin.blog.ya.YaApiResult;
import com.lambkin.blog.ya.YaPageBean;
import jakarta.annotation.Resource;
import com.lambkin.blog.service.ICommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>评论表--Comment--web</p>
 *
 * @author lambkinya
 * @since 2023-09-14 00:25:58
 */
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Resource
    private ICommentService commentServiceImpl;


    @GetMapping("/list")
    public YaApiResult<?> queryList(Integer pageNo, Integer pageSize, String articleNo, Integer type) {
        YaPageBean<CommentVo> result = commentServiceImpl.queryList(pageNo, pageSize, articleNo, type);
        return YaApiResult.okResult(result);
    }

    @GetMapping("/{commentNo}/reply")
    public YaApiResult<?> queryReplyComment(@PathVariable String commentNo, Integer pageNo) {
        YaPageBean<CommentVo> result = commentServiceImpl.queryReplyComment(commentNo, pageNo);
        return YaApiResult.okResult(result);
    }

    @PostMapping("/add")
    public YaApiResult<?> add(@RequestBody AddCommentDto comment) {

        commentServiceImpl.add(comment);
        return YaApiResult.okResult();
    }
}

