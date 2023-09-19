package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-18 11:40:37
 */
@Data
public class RecommendArticleVo {

    /**
     * 文章编号
     */
    private String no;

    /**
     * 所属分类编号
     */
    private String categoryNo;

    /**
     * 所属标签名称
     */
    private String categoryName;

    /**
     * 标题
     */
    private String title;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
