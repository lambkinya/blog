package com.lambkin.blog.enums;

/**
 * @author lambkin-wow
 * @since 2023-09-09 22:44:51
 */
public enum YaApiCodeEnum {

    /**
     *
     */
    SUCCESS(200,"操作成功"),
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"系统错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONE_EXIST(502,"手机号已存在"),
    EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    LOGIN_ERROR(505,"用户名或密码错误");


    final int code;
    final String msg;

    YaApiCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
