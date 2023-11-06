package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * 友链表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("friend_link")
public class FriendLinkEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 友链编号
     */
    private String no;

    /**
     * 标题
     */
    private String title;

    /**
     * 分类
     */
    private Boolean classify;

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
     * 资源类型
     */
    private String type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否启用[0:否，1:是]
     */
    private Boolean status;
}
