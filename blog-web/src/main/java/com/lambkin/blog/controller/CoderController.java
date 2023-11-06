package com.lambkin.blog.controller;

import com.lambkin.blog.model.dto.coder.CoderSignupRequest;
import com.lambkin.blog.model.vo.CoderVO;
import com.lambkin.blog.service.ICoderService;
import com.lambkin.blog.ya.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户 - Coder
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/coders")
public class CoderController {

    @Resource
    private ICoderService coderServiceImpl;


    /**
     * 邮箱注册
     */
    @PostMapping("/signup")
    public ApiResponse<CoderVO> signUp(@Validated @RequestBody CoderSignupRequest param) {
        CoderVO coderInfo = coderServiceImpl.signup(param);
        return ApiResponse.ok(coderInfo);
    }


    /**
     * 账号登录
     */
    @PostMapping("/sign-in")
    public ApiResponse<CoderVO> signIn(@RequestParam("account") String account,
                                      @RequestParam("password") String password,
                                      @RequestParam(value = "isAdmin", defaultValue = "false") Boolean isAdmin) {
        CoderVO coderInfo =  coderServiceImpl.signIn(account, password, isAdmin);

        return ApiResponse.ok(coderInfo);
    }


}
