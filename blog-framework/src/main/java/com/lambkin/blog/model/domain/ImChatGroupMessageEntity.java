package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>群聊记录表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("im_chat_group_message")
public class ImChatGroupMessageEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -52210586374632737L;


    /**
     * 编号
     */
    private String no;

    /**
     * 群ID
     */
    private String groupNo;

    /**
     * 发送ID
     */
    private String fromNo;

    /**
     * 接收ID
     */
    private String toNo;

    /**
     * 内容
     */
    private String content;

}


