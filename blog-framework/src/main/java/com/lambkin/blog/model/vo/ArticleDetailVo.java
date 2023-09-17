package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-10 21:35:31
 */
@Data
public class ArticleDetailVo {

    /**
     * 文章编号
     */
    private String no;

    /**
     * Coder编号
     */
    private String coderNo;

    /**
     * Coder用户名
     */
    private String coderName;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 访问数
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
     * 分类信息
     */
    private CategoryVo categoryInfo;

    /**
     * 标签信息
     */
    private TagVo tagInfo;

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
