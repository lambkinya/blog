package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * <p>文章表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("article")
public class ArticleEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = -72130369177915062L;

    /**
     * 文章编号
     */
    private String no;

    /**
     * Coder编号
     */
    private String coderNo;

    /**
     * 所属分类编号
     */
    private String categoryNo;

    /**
     * 所属标签编号
     */
    private String tagNo;

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
     * 是否推荐[0:否，1:是]
     */
    private Integer recommendStatus;

    /**
     * 文章状态（0草稿，1.公开，2.仅自己可见，3...）
     */
    private Integer viewStatus;

    /**
     * 是否允许评论 0否，1是
     */
    private Integer commentStatus;

}


