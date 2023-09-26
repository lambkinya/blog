package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-24 18:56:37
 */
@Data
public class AdminArticlePageVo {

    /**
     * 文章编号
     */
    private String no;

    /**
     * Coder 编号
     */
    private String coderNo;

    /**
     * Coder 用户名
     */
    private String coderName;

    /**
     * 所属分类编号
     */
    private String categoryNo;

    /**
     * 所属分类名称
     */
    private String categoryName;

    /**
     * 所属标签编号
     */
    private String tagNo;

    /**
     * 所属标签名称
     */
    private String tagName;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 密码
     */
    private String password;

    /**
     * 访问量
     */
    private Integer viewCount;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 文章状态（0草稿，1.公开，2.仅自己可见，3...）
     */
    private Integer viewStatus;

    /**
     * 是否推荐[0:否，1:是]
     */
    private Integer recommendStatus;

    /**
     * 是否允许评论 0否，1是
     */
    private Integer commentStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
