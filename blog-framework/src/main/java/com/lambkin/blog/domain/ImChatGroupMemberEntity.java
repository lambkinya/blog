package com.lambkin.blog.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>聊天群成员表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("im_chat_group_member")
public class ImChatGroupMemberEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -22353963429282993L;

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
    private Integer adminFlag;

    /**
     * 用户状态[0:未审核，1:审核通过，2:禁言]
     */
    private Integer coderStatus;

}


