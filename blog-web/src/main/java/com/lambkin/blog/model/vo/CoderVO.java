package com.lambkin.blog.model.vo;

import lombok.Data;

/**
 * 脱敏后的 用户信息
 *
 * @author lambkinya
 * @since 2023-10-30 19:49:45
 */
@Data
public class CoderVO {

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
    private Boolean gender;

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
     * 类型 0.admin 1.coder 2.游客
     */
    private Integer type;

    /**
     * 说点什么...
     */
    private String saying;

    /**
     * 该用户是否为 站长
     */
    private Boolean isBoss;

    /**
     * 权限 token
     */
    private String accessToken;

}
