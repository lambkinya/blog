package com.lambkin.blog.ya;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类父类
 *
 * @author lambkinya
 * @since 2023-09-10 11:26:13
 */
@Data
public class BaseBean implements Serializable {

    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除标记，0.未删除，1.已删除
     */
    @TableLogic
    private Integer yn;
}
