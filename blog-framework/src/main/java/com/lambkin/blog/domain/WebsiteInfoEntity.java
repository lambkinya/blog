package com.lambkin.blog.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * <p>网站信息表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 15:05:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("website_info")
public class WebsiteInfoEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = 299646006052823960L;
    
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
    private Integer status;
    
}


