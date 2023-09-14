package com.lambkin.blog.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
     * Coder
     */
    private String coderName;

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
     * 文章所属标签列表
     */
    private List<TagVo> tagList;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
