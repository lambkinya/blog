package com.lambkin.blog.model.dto;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-19 19:53:23
 */
@Data
public class ApplyFriendLinkDto {

    /**
     * 名称
     */
    private String name;

    /**
     * 封面
     */
    private String cover;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 链接
     */
    private String url;
}
