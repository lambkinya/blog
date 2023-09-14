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
     * 账号
     */
    private String account;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String avatar;

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
     * 类型 0.admin 1.游客 2.创作者
     */
    private Integer type;

    /**
     * 说点什么...
     */
    private String saying;
}
