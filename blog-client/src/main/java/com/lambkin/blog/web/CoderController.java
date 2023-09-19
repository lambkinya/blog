package com.lambkin.blog.web;

import com.lambkin.blog.model.CoderInfoVo;
import com.lambkin.blog.service.ICoderService;
import com.lambkin.blog.ya.YaApiResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public YaApiResult<?> queryLoginInfo(HttpServletRequest request) {
        CoderInfoVo result = coderServiceImpl.queryInfoByNo(request.getHeader("Authorization"));
        return YaApiResult.ok(result);
    }
}

