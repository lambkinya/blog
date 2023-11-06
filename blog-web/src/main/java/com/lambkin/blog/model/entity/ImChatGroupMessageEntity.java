package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * 群聊记录表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("im_chat_group_message")
public class ImChatGroupMessageEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

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
