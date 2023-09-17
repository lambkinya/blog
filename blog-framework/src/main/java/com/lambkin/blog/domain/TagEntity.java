package com.lambkin.blog.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * <p>标签表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tag")
public class TagEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -79267588480605331L;

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


