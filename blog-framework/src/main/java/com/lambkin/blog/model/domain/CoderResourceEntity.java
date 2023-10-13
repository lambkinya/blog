package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>coder资源信息表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("coder_resource")
public class CoderResourceEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 538792835328244128L;

    /**
     * coder编号
     */
    private String coderNo;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 资源路径
     */
    private String path;

    /**
     * 资源内容的大小，单位：字节
     */
    private Integer size;

    /**
     * 资源的 MIME 类型
     */
    private String mimeType;

    /**
     * 是否启用[0:否，1:是]
     */
    private Integer status;

}


