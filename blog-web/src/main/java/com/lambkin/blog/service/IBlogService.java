package com.lambkin.blog.service;

/**
 * 博客功能服务
 *
 * @author lambkinya
 * @since 2023-10-31 13:57:48
 */
public interface IBlogService {

    /**
     * 用户获取验证码
     * @param type 1.邮箱验证码 2.手机号验证码
     */
    void getCode(Integer type);

    /**
     * 向 目标 发送验证码
     * @param type 1.邮箱 2.手机号
     * @param target 目标的邮箱或者手机号
     */
    void codeTo(Integer type, String target);
}
