package com.lambkin.blog.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-11 10:54:38
 */
@Data
public class ArticleListVo {

    /**
     * 文章编号
     */
    private String no;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 所属分类编号
     */
    private String categoryNo;

    /**
     * 所属分类名称
     */
    private String categoryName;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 是否置顶（0否，1是）
     */
    private String isTop;

    /**
     * 访问量
     */
    private Long viewCount;

    /**
     * 是否允许评论 1是，0否
     */
    private String isComment;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
