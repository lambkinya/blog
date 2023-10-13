package com.lambkin.blog.model.dto;

import com.lambkin.blog.ya.PageRequest;
import lombok.Data;

/**
 * <p>后台管理系统 - 分页查询评论 - 请求参数</p>
 *
 * @author lambkinya
 * @since 2023-09-26 22:14:15
 */
@Data
public class AdminCommentPageRequest extends PageRequest {

    private String type;

    private String sourceNo;

    private String coderNo;
}
