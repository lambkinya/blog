package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * 好友表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("im_chat_coder_friend")
public class ImChatCoderFriendEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String no;

    /**
     * coder编号
     */
    private String coderNo;

    /**
     * 好友编号
     */
    private String friendNo;

    /**
     * 好友状态[0:未审核，1:审核通过]
     */
    private Byte friendStatus;

    /**
     * 备注
     */
    private String remark;
}
