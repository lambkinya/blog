package com.lambkin.blog.model.dto;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-16 02:17:50
 */
@Data
public class CoderSimpleInfoDto {

    /**
     * Coder编号
     */
    private String no;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 个人网站地址
     */
    private String website;

    /**
     * 说点什么...
     */
    private String saying;
}
