package com.lambkin.blog.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;

import java.io.Serial;

import lombok.Data;

/**
 * <p>评论表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
@Data
@TableName("comment")
public class CommentEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = 474892791532009475L;


    /**
     * 评论编号
     */
    private String no;

    /**
     * 文章编号
     */
    private String articleNo;

    /**
     * 评论类型（1文章 2友链 3树洞）
     */
    private Integer type;

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
    private Integer status;

}


