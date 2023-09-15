package com.lambkin.blog.model;

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
     * 评论者编号
     */
    private String coderNo;

    /**
     * 评论者用户名
     */
    private String nickname;

    /**
     * 评论者头像
     */
    private String avatar;

    /**
     * 根评论编号
     */
    private String rootCommentNo;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 所回复的目标评论的用户编号
     */
    private String toCoderNo;

    /**
     * 所回复的目标评论的用户名
     */
    private String toNickname;

    /**
     * 回复目标评论编号
     */
    private String toCommentNo;

    /**
     * 评论时间
     */
    private LocalDateTime createTime;

    /**
     * 点赞数量
     */
    private Integer likeCount;

    /**
     * 该评论下的回复数量
     */
    private Integer replyCount;

    /**
     * 其下面的子评论
     */
    private List<CommentVo> childrenCommentList;

    /**
     * 当前评论位于第几页
     */
    private Integer pageNo;
}
