package com.lambkin.blog.constant;

/**
 * 验证码 常量
 *
 * @author lambkinya
 * @since 2023-10-13 11:36:27
 */
public interface CodeConstant {

    /**
     * 验证码邮件发送次数
     */
    int CODE_MAIL_COUNT = 3;

    /**
     * 验证码邮件
     */
    String CODE_MAIL = "code_mail_";

    /**
     * 注册用户验证码
     */
    String SIGNUP_MAIL_CODE = "signup_mail_code_";

    /**
     * Code过期时间：1天
     */
    long CODE_EXPIRE = 86400;
}
