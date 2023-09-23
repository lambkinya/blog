package com.lambkin.blog.service;

import com.lambkin.blog.model.dto.CommentPageDto;
import com.lambkin.blog.model.dto.PublishCommentDto;
import com.lambkin.blog.ya.YaPageBean;

/**
 * <p>评论表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
public interface ICommentService {

    YaPageBean<?> queryCommentByConditionPage(CommentPageDto dto);

    void publishComment(PublishCommentDto dto);

    Integer countCommentTotalByArticleNoOrType(String articleNo, Integer type);
}

