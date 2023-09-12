package com.lambkin.blog.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import java.io.Serial;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>分类表--Category--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-10 20:02:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("category")
public class CategoryEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = 632457633582748268L;
    
    /**
     * 分类编号
     */
    private String no;
    
    /**
     * 分类名
     */
    private String name;
    
    /**
     * 父分类编号，如果没有父分类为-1
     */
    private String parentNo;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 状态0:正常,1禁用
     */
    private String status;
}


