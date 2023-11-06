package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * 聊天群成员表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("im_chat_group_member")
public class ImChatGroupMemberEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String no;

    /**
     * 群编号
     */
    private String groupNo;

    /**
     * coder编号
     */
    private String coderNo;

    /**
     * 审核用户编号
     */
    private String verifyCoderNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否管理员[0:否，1:是]
     */
    private Boolean adminFlag;

    /**
     * 用户状态[0:未审核，1:审核通过，2:禁言]
     */
    private Boolean coderStatus;
}
