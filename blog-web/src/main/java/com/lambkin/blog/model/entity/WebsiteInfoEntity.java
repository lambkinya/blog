package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * 网站信息表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("website_info")
public class WebsiteInfoEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String no;

    /**
     * 网站名称
     */
    private String name;

    /**
     * 网站信息
     */
    private String title;

    /**
     * 公告
     */
    private String notices;

    /**
     * 页脚
     */
    private String footer;

    /**
     * 背景
     */
    private String backgroundImage;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 随机头像
     */
    private String randomAvatar;

    /**
     * 随机名称
     */
    private String randomName;

    /**
     * 随机封面
     */
    private String randomCover;

    /**
     * 看板娘消息
     */
    private String waifuJson;

    /**
     * 是否启用[0:否，1:是]
     */
    private Boolean status;
}
