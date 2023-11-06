package com.lambkin.blog.constant;

/**
 * 缓存 常量
 *
 * @author lambkinya
 * @since 2023-10-13 11:36:27
 */
public interface CacheConsts {

    /**
     * 验证码邮件发送次数
     */
    int CODE_MAIL_COUNT = 3;

    /**
     * 验证码邮件
     */
    String CODE_MAIL = "code_mail_";

    /**
     * 用户注册 邮箱验证码
     */
    String CODER_SIGNUP_MAIL_CODE = "signup_mail_code_";

    /**
     * Code过期时间：1天
     */
    long CODE_EXPIRE = 86400;

    /**
     * key : coder no
     * value : coder token
     */
    String USER_TOKEN = "user_token_";

    /**
     * key : coder no
     * value : coder token
     */
    String ADMIN_TOKEN = "admin_token_";

}
