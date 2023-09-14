package com.lambkin.blog.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import java.io.Serial;
import lombok.Data;

/**
 * <p>标签--Tag--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-14 20:49:26
 */
@Data
@TableName("tag")
public class TagEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -81938679450460602L;

    
    /**
     * 标签编号
     */
    private String no;
    
    /**
     * 标签名
     */
    private String name;
    
    /**
     * 备注
     */
    private String remark;
    
}


