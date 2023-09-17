package com.lambkin.blog.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>单聊记录表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("im_chat_single_message")
public class ImChatSingleMessageEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = 654624339325964467L;


    /**
     * 编号
     */
    private String no;

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

    /**
     * 是否已读[0:未读，1:已读]
     */
    private Integer messageStatus;

}


