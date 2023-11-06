package com.lambkin.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型枚举
 *
 * @author lambkinya
 * @since 2023-11-06 16:19:30
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

    /**
     * 用户类型
     */
    ADMIN(0, "站长"),
    CODER(1, "管理员"),
    TOURIST(2, "游客"),

    ;


    private final int code;
    private final String desc;


    public static CommentTypeEnum codeOf(Integer code) {
        if (null == code) {
            return null;
        }
        for (CommentTypeEnum c : CommentTypeEnum.values()) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    public static CommentTypeEnum descOf(String desc) {
        if (null == desc) {
            return null;
        }
        for (CommentTypeEnum c : CommentTypeEnum.values()) {
            if (c.getDesc().equals(desc)) {
                return c;
            }
        }
        return null;
    }

}
