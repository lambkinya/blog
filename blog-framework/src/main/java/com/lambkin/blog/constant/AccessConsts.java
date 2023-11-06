package com.lambkin.blog.constant;

/**
 * 有关权限的常量 例如: token
 *
 * @author lambkinya
 * @since 2023-10-31 13:13:41
 */
public interface AccessConsts {

    /**
     * token 请求头
     */
    String TOKEN_HEADER = "Authorization";

    /**
     * Token过期时间：10天
     */
    long TOKEN_EXPIRE = 864000;

    /**
     * 普通用户 token 前缀
     * 存入缓存 与 用户信息 绑定
     */
    String USER_ACCESS_TOKEN = "user_access_token_";

    /**
     * admin token 前缀
     * 存入缓存 与 用户信息 绑定
     */
    String ADMIN_ACCESS_TOKEN = "admin_access_token_";

}
