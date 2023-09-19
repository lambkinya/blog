package com.lambkin.blog.model;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-14 15:13:49
 */
@Data
public class CoderInfoVo {

    /**
     * Coder编号
     */
    private String no;

    /**
     * 用户名
     */
    private String username;

    /**
     * 性别[1:男，2:女，0:保密]
     */
    private Integer gender;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 个人网站地址
     */
    private String website;

    /**
     * github地址
     */
    private String github;

    /**
     * gitee地址
     */
    private String gitee;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 说点什么...
     */
    private String saying;

}
