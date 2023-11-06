package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * 评论表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("comment")
public class CommentEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 评论编号
     */
    private String no;

    /**
     * 来源
     */
    private String source;

    /**
     * 评论类型（1文章 2祝福 3树洞）
     */
    private Boolean type;

    /**
     * 评论者编号
     */
    private String coderNo;

    /**
     * 根评论编号
     */
    private String rootCommentNo;

    /**
     * 所回复的目标评论的用户编号
     */
    private String toCoderNo;

    /**
     * 所回复的目标评论的评论编号
     */
    private String toCommentNo;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论额外信息
     */
    private String otherInfo;

    /**
     * 点赞数量
     */
    private Integer likeCount;

    /**
     * 评论是否通过 0.未通过 1.已通过 2.待审核
     */
    private Boolean status;
}
