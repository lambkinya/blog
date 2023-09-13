package com.lambkin.blog.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import java.io.Serial;
import lombok.Data;

/**
 * <p>Coder--Coder--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-13 11:17:14
 */
@Data
@TableName("coder")
public class CoderEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -72734673287822815L;
    
    /**
     * Coder编号
     */
    private String no;
    
    /**
     * 账号
     */
    private String account;
    
    /**
     * 昵称
     */
    private String nickname;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 头像地址
     */
    private String avatar;
    
    /**
     * github地址
     */
    private String github;
    
    /**
     * gitee地址
     */
    private String gitee;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 用户手机号
     */
    private String phone;
    
    /**
     * 类型 0.admin 1.游客 2.创作者
     */
    private Integer type;
    
    /**
     * 说点什么...
     */
    private String saying;
    
}


