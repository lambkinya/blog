package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>聊天群--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("im_chat_group")
public class ImChatGroupEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 502499630168057186L;

    /**
     * 编号
     */
    private String no;

    /**
     * 群主编号
     */
    private String masterNo;

    /**
     * 群名称
     */
    private String groupName;

    /**
     * 群头像
     */
    private String avatar;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 公告
     */
    private String notice;

    /**
     * 进入方式[0:无需验证，1:需要群主或管理员同意]
     */
    private Integer inType;

    /**
     * 类型[1:聊天群，2:话题]
     */
    private Integer groupType;
}


