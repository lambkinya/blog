package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * coder资源信息表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("file_info")
public class FileInfoEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

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
    private Boolean status;

    /**
     * 存储平台 1.七牛云
     */
    private Boolean storeType;
}
