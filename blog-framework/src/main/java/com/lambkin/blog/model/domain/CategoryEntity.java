package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * <p>分类表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("category")
public class CategoryEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -80838885550181653L;

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
    private Integer type;

    /**
     * 导航栏分类优先级：数字小的在前面
     */
    private Integer priority;

}


