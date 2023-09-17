package com.lambkin.blog.model.vo;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-17 19:33:14
 */
@Data
public class CategoryVo {

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
}
