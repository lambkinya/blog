package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * 分类表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("category")
public class CategoryEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类编号
     */
    private String no;

    /**
     * 分类名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 分类类型[0:导航栏分类，1:普通分类]
     */
    private Boolean type;

    /**
     * 导航栏分类优先级：数字小的在前面
     */
    private Integer priority;
}
