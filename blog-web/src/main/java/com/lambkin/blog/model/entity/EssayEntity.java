package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import lombok.Data;

import java.io.Serial;

/**
 * 随笔表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("essay")
public class EssayEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String no;

    /**
     * coder编号
     */
    private String coderNo;

    /**
     * 内容
     */
    private String content;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 类型 1.朋友圈
     */
    private Integer type;

    /**
     * 来源
     */
    private String source;

    /**
     * 是否公开[0:仅自己可见，1:所有人可见]
     */
    private Boolean viewStatus;
}
