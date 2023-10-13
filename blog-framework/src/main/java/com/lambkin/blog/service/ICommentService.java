package com.lambkin.blog.service;

import com.lambkin.blog.model.dto.AdminCommentPageRequest;
import com.lambkin.blog.model.dto.CommentPageRequest;
import com.lambkin.blog.model.dto.PublishCommentDto;
import com.lambkin.blog.ya.YaPage;

/**
 * <p>评论表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
public interface ICommentService {

    YaPage<?> queryCommentByConditionPage(CommentPageRequest dto);

    void publishComment(PublishCommentDto dto);

    Integer countCommentTotalByArticleNoOrType(String articleNo, Integer type);

    YaPage<?> queryCommentByConditionPageAdmin(AdminCommentPageRequest dto);
}

