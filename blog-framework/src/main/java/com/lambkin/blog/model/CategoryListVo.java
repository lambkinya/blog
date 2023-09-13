package com.lambkin.blog.model;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-10 20:13:50
 */
@Data
public class CategoryListVo {

    /**
     * 分类编号
     */
    private String no;

    /**
     * 父分类编号，如果没有父分类为-1
     */
    private String parentNo;

    /**
     * 分类名
     */
    private String name;

    /**
     * 描述
     */
    private String description;
}
