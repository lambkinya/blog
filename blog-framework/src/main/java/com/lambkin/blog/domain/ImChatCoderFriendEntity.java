package com.lambkin.blog.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>好友表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("im_chat_coder_friend")
public class ImChatCoderFriendEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = 912039144500258783L;

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
    private Integer friendStatus;

    /**
     * 备注
     */
    private String remark;

}


