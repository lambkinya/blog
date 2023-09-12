package com.lambkin.blog.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import java.io.Serial;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>文章表--Article--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-10 20:02:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("article")
public class ArticleEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -64058372545497309L;
    
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
     * 缩略图
     */
    private String thumbnail;
    
    /**
     * 是否置顶（0否，1是）
     */
    private String isTop;
    
    /**
     * 状态（0草稿，1.公开，2.仅自己可见，3...）
     */
    private String status;
    
    /**
     * 访问量
     */
    private Long viewCount;
    
    /**
     * 是否允许评论 1是，0否
     */
    private String isComment;
}

