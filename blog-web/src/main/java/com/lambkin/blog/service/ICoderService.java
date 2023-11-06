package com.lambkin.blog.service;

import com.lambkin.blog.model.dto.coder.CoderSignupRequest;
import com.lambkin.blog.model.entity.CoderEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lambkin.blog.model.vo.CoderVO;

/**
 * Coder 服务类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
public interface ICoderService extends IService<CoderEntity> {

    /**
     * 注册用户
     *
     * @param param 用户注册信息
     * @return 脱敏后的用户信息
     */
    CoderVO signup(CoderSignupRequest param);

    /**
     * 账号登录
     * @param account 用户名 / 邮箱 / 手机号
     * @param password 加密过后的密码
     * @param isAdmin 是否是管理员登录（博客后台）
     * @return 脱敏后的用户信息
     */
    CoderVO signIn(String account, String password, Boolean isAdmin);
}
