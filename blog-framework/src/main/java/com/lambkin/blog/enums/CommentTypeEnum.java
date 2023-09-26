package com.lambkin.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-26 21:56:33
 */
@Getter
@AllArgsConstructor
public enum CommentTypeEnum {


    /**
     *
     */
    ARTICLE(1, "文章评论"),
    BLESSING(2, "恋爱祝福"),
    MESSAGE(3, "树洞留言"),
    ;

    final Integer code;
    final String desc;


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
