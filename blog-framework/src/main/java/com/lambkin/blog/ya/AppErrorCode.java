package com.lambkin.blog.ya;

import lombok.Getter;

/**
 * @author lambkinya
 * @since 2023-09-09 22:44:51
 */
@Getter
public enum AppErrorCode {

    /**
     * 响应码枚举
     */
    SUCCESS(0,"ok"),

    PARAMS_ERROR(40000, "请求参数错误..."),
    NULL_ERROR(40001, "请求数据为空..."),
    ACCOUNT_HAS_EXIST(40002, "账号已存在..."),

    NOT_LOGIN(40100,"需要登录后操作..."),
    PERMISSION_DENIED(40101,"无权限, 拒绝访问..."),

    SYSTEM_ERROR(50000,"系统错误..."),
    ;


    final int code;
    final String message;
    String description = "";



    AppErrorCode(int code, String errorMessage){
        this.code = code;
        this.message = errorMessage;
    }

    AppErrorCode(int code, String errorMessage, String description){
        this.code = code;
        this.message = errorMessage;
        this.description = description;
    }
}
