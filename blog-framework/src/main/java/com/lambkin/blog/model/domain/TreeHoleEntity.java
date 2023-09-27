package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * <p>树洞表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tree_hole")
public class TreeHoleEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -22637883757032270L;

    /**
     * 编号
     */
    private String no;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 留言
     */
    private String message;

}


