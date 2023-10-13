package com.lambkin.blog.web;

import com.lambkin.blog.model.vo.SweetheartVo;
import com.lambkin.blog.service.ISweetheartService;
import com.lambkin.blog.ya.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>恋人表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/sweethearts")
public class SweetheartController {

    @Resource
    private ISweetheartService sweetheartServiceImpl;


    @GetMapping("/admin")
    private ApiResponse<?> queryAdminSweetheart() {
        SweetheartVo result = sweetheartServiceImpl.queryAdminSweetheart();
        return ApiResponse.ok(result);
    }

}

