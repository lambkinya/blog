package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-19 19:39:35
 */
@Data
public class FriendLinkVo {

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
