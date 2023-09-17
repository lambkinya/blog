package com.lambkin.blog.model.vo;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-17 15:08:34
 */
@Data
public class WebsiteInfoVo {

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

}
