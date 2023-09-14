package com.lambkin.blog.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import java.io.Serial;
import lombok.Data;

/**
 * <p>评论表--Comment--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-14 01:32:54
 */
@Data
@TableName("comment")
public class CommentEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -99582995761792846L;
    
    /**
     * 评论编号
     */
    private String no;
    
    /**
     * 评论类型（0代表文章评论，1代表友链评论）
     */
    private Integer type;
    
    /**
     * 文章编号
     */
    private String articleNo;
    
    /**
     * 评论者编号
     */
    private String coderNo;
    
    /**
     * 根评论编号
     */
    private String rootCommentNo;
    
    /**
     * 评论内容
     */
    private String content;
    
    /**
     * 点赞数量
     */
    private Integer likeCount;
    
    /**
     * 所回复的目标评论的用户编号
     */
    private String toUserNo;
    
    /**
     * 所回复的目标评论的评论编号
     */
    private String toCommentNo;
    
    /**
     * 评论是否通过 0.未通过 1.已通过 2.待审核
     */
    private Integer status;
    
}


