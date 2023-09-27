package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>后台管理系统 - 用户分页列表 - VO</p>
 *
 * @author lambkinya
 * @since 2023-09-27 10:49:33
 */
@Data
public class AdminCoderPageVo {

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
     * 是否启用[0:否，1:是]
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
