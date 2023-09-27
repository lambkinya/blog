package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

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
    private Integer type;

    /**
     * 是否公开[0:仅自己可见，1:所有人可见]
     */
    private Integer isPublic;

}


