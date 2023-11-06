package com.lambkin.blog.model.dto.coder;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 用户注册 -- 请求参数
 *
 * @author lambkinya
 * @since 2023-10-30 19:53:52
 */
@Data
public class CoderSignupRequest {

    /**
     * 用户名
     */
    @NotBlank(message = "账号不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String code;

}
