package com.lambkin.blog.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>文章表--Article--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-10 04:47:04
 */
@Data
@TableName("article")
public class ArticleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 646970030593919362L;
        
    /**
     * 自增ID
     */
    private Long id;
    
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
     * 所属分类id
     */
    private Long categoryId;
    
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
    
    /**
     * 创建者
     */
    private Long createBy;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新者
     */
    private Long updateBy;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    private Integer yn;
    
}


