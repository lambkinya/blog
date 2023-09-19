package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-14 00:56:52
 */
@Data
public class CommentVo {

    /**
     * 评论编号
     */
    private String no;

    /**
     * 文章编号
     */
    private String articleNo;

    /**
     * 评论者编号
     */
    private String coderNo;

    /**
     * 评论者头像
     */
    private String coderAvatar;

    /**
     * 评论者用户名
     */
    private String coderName;

    /**
     * 根评论编号
     */
    private String rootCommentNo;

    /**
     * 所回复的目标评论的用户编号
     */
    private String toCoderNo;

    /**
     * 所回复的目标评论的用户名
     */
    private String toCoderName;

    /**
     * 所回复的目标评论的评论编号
     */
    private String toCommentNo;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 点赞数量
     */
    private Integer likeCount;

    /**
     * 评论时间
     */
    private LocalDateTime createTime;

    /**
     * 该评论下的回复数量
     */
    private Integer childrenCommentTotal;

    /**
     * 其下面的子评论
     */
    private List<CommentVo> childrenCommentList;

}
