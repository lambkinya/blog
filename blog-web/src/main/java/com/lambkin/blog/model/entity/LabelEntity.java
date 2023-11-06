package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * 标签表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("label")
public class LabelEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 标签编号
     */
    private String no;

    /**
     * 分类编号
     */
    private String categoryNo;

    /**
     * 标签名
     */
    private String name;

    /**
     * 描述
     */
    private String description;
}
