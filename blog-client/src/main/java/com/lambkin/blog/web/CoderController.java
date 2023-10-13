package com.lambkin.blog.web;

import com.lambkin.blog.model.CoderInfoVo;
import com.lambkin.blog.model.dto.AdminCoderPageRequest;
import com.lambkin.blog.service.ICoderService;
import com.lambkin.blog.ya.ApiResponse;
import com.lambkin.blog.ya.YaPage;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Coder--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/coders")
public class CoderController {

    @Resource
    private ICoderService coderServiceImpl;


    @GetMapping("/t-info")
    public ApiResponse<?> queryLoginInfo(HttpServletRequest request) {
        CoderInfoVo result = coderServiceImpl.queryInfoByNo(request.getHeader("Authorization"));
        return ApiResponse.ok(result);
    }


    @PostMapping("/list-admin")
    public ApiResponse<?> queryCoderPageAdmin(@RequestBody AdminCoderPageRequest dto) {
        YaPage<?> result = coderServiceImpl.queryCoderPageAdmin(dto);
        return ApiResponse.ok(result);
    }

}

