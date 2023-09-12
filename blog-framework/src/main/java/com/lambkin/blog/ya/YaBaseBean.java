package com.lambkin.blog.ya;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-10 11:26:13
 */
@Data
public class YaBaseBean implements Serializable {

    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateTime;

    /**
     * 版本号，每次修改+1
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version = 0;

    /**
     * 逻辑删除标记，0代表未删除，1代表已删除
     */
    @TableLogic
    private Integer yn;
}
