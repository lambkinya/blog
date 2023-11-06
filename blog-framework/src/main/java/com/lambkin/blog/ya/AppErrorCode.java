package com.lambkin.blog.ya;

import lombok.Getter;

/**
 * 错误码
 * A : 客户端错误    B : 系统错误    C : 调用第三方服务错误
 *
 * @author lambkinya
 * @since 2023-09-09 22:44:51
 */
@Getter
public enum AppErrorCode {

    /**
     * 响应码枚举
     */
    SUCCESS("00000", "ok"),

    CLIENT_ERROR("A0001", "客户端错误..."),
    SYSTEM_ERROR("B0001", "系统错误..."),
    THIRD_PARTY_ERROR("C0001", "调用第三方服务错误..."),

    PARAMS_ERROR("A0101", "请求参数错误..."),
    NULL_ERROR("A0102", "请求数据为空..."),

    ACCOUNT_HAS_EXIST("A0201", "账号已存在..."),
    EMAIL_HAS_EXIST("A0202", "邮箱已被绑定..."),
    EMAIL_NOT_BINDING("A0203", "邮箱未绑定..."),
    PHONE_NOT_BINDING("A0204", "手机号未绑定..."),

    NOT_LOGIN("A0301", "需要登录后操作..."),
    PERMISSION_DENIED("A0302", "无权限, 拒绝访问..."),
    ACCOUNT_BANNED("A0303", "该账号已被封禁..."),



    ;


    final String code;
    final String message;


    AppErrorCode(String code, String errorMessage) {
        this.code = code;
        this.message = errorMessage;
    }

}
