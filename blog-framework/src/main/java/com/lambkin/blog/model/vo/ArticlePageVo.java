package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-11 10:54:38
 */
@Data
public class ArticlePageVo {


    /**
     * 文章编号
     */
    private String no;

    /**
     * Coder编号
     */
    private String coderNo;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章摘要
     */
    private String summary;

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
     * 创建时间
     */
    private LocalDateTime createTime;
}
