package com.lambkin.blog.model.vo;

import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-17 21:33:35
 */
@Data
public class CategoryDetailVo {

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
     * 导航栏分类优先级：数字小的在前面
     */
    private Integer priority;

    /**
     * 关联的文章数量
     */
    private Integer articleCount;

    /**
     * 标签信息
     */
    private List<TagDetailVo> tagInfoList;
}
