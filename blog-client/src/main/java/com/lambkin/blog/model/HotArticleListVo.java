package com.lambkin.blog.model;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-10 10:26:42
 */
@Data
public class HotArticleListVo {

    /**
     * 文章编号
     */
    private String no;

    /**
     * Coder编号
     */
    private String coderNo;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 标题
     */
    private String title;

    /**
     * 访问量
     */
    private Long viewCount;
}
