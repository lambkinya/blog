package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>微言表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:28
 */
@Data
public class WeiYanPageVo {

    /**
     * 编号
     */
    private String no;

    /**
     * 内容
     */
    private String content;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}


