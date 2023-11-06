package com.lambkin.blog.constant;

/**
 * 系统配置 常量
 *
 * @author lambkinya
 * @since 2023-10-30 20:09:58
 */
public interface SystemConfigConsts {

    /**
     * 前后端加密使用的 密钥
     */
    String CRYPTOJS_KEY = "aaaaaaaaaaaaaaaa";

    /**
     * 用户每天最多发送 3 次验证码
     */
    int CODE_MAIL_COUNT = 3;

}
