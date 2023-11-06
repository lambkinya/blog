package com.lambkin.blog.controller;

import com.lambkin.blog.service.IBlogService;
import com.lambkin.blog.ya.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * function
 *
 * @author lambkinya
 * @since 2023-10-31 13:49:48
 */
@RestController("/functions")
public class BlogController {

    @Resource
    private IBlogService blogServiceImpl;


    /**
     * 向当前登录用户发送验证码
     *
     * @param type 1.手机号 2.邮箱
     * @return ok / error
     */
    @GetMapping("/code")
    public ApiResponse<?> getCode(@RequestParam("type") Integer type) {
        blogServiceImpl.getCode(type);
        return ApiResponse.ok();
    }

    /**
     * 向目标发送验证码
     *
     * @param type   1.手机号 2.邮箱
     * @param target 手机号 / 邮箱地址
     * @return ok / error
     */
    @GetMapping("/code-to")
    public ApiResponse<?> codeTo(@RequestParam("type") Integer type, @RequestParam("target") String target) {
        blogServiceImpl.codeTo(type, target);
        return ApiResponse.ok();
    }

}
