package com.lambkin.blog.model.vo;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-14 20:59:21
 */
@Data
public class TagVo {

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
}
