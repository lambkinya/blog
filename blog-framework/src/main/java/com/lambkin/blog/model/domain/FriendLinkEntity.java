package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>友链表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("friend_link")
public class FriendLinkEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = -18920724957259547L;

    /**
     * 友链编号
     */
    private String no;

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
     * 是否启用[0:否，1:是]
     */
    private Integer status;

}


