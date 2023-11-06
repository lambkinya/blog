package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import lombok.Data;

import java.io.Serial;

/**
 * Coder
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("coder")
public class CoderEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Coder编号
     */
    private String no;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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
     * 是否启用[0:否，1:是]
     */
    private Boolean status;

    public CoderEntity(String no) {
        this.no = no;
    }

    public CoderEntity() {
    }

}
