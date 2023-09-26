package com.lambkin.blog.model.vo;

import lombok.Data;

/**
 * <p>管理系统 - 分类列表 - VO</p>
 *
 * @author lambkinya
 * @since 2023-09-26 21:26:49
 */
@Data
public class AdminCategoryVo {

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

    /**
     * 文章总数
     */
    private Integer articleCount;
}
