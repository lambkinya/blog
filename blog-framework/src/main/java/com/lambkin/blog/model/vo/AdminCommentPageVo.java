package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>后台管理系统 - 分页查询评论 - 返回值</p>
 *
 * @author lambkinya
 * @since 2023-09-26 22:19:41
 */
@Data
public class AdminCommentPageVo {

    /**
     * 评论编号
     */
    private String no;

    /**
     * 评论来源编号
     */
    private String sourceNo;

    /**
     * 评论类型（1.文章 2.祝福 3.树洞）
     */
    private String type;

    /**
     * 评论者编号
     */
    private String coderNo;

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
     * 创建时间
     */
    private LocalDateTime createTime;

}
