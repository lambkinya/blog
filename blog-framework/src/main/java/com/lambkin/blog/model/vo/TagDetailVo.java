package com.lambkin.blog.model.vo;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-17 21:36:03
 */
@Data
public class TagDetailVo {

    /**
     * 标签编号
     */
    private String no;

    /**
     * 标签名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 关联的文章数量
     */
    private Integer articleCount;
}
