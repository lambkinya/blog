package com.lambkin.blog.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>微言表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wei_yan")
public class WeiYanEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -52527046002983069L;

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
     * 类型
     */
    private String type;

    /**
     * 来源标识
     */
    private Integer source;

    /**
     * 是否公开[0:仅自己可见，1:所有人可见]
     */
    private Integer isPublic;

}


