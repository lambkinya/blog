package com.lambkin.blog.service;

import com.lambkin.blog.model.CommentVo;
import com.lambkin.blog.model.dto.AddCommentDto;
import com.lambkin.blog.ya.YaPageBean;

import java.util.List;

/**
 * <p>评论表--Comment--service</p>
 *
 * @author lambkinya
 * @since 2023-09-14 00:25:58
 */
public interface ICommentService {

    YaPageBean<CommentVo> queryList(Integer pageNo, Integer pageSize, String articleNo, Integer type);

    YaPageBean<CommentVo> queryReplyComment(String commentNo, Integer pageNo);

    void add(AddCommentDto comment);
}

