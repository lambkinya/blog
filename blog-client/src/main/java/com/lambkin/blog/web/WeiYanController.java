package com.lambkin.blog.web;

import com.lambkin.blog.service.IWeiYanService;
import com.lambkin.blog.ya.YaApiResult;
import com.lambkin.blog.ya.YaBasePageDto;
import com.lambkin.blog.ya.YaPageBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>微言表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/weiYan")
public class WeiYanController {

    @Resource
    private IWeiYanService weiYanServiceImpl;


    @PostMapping("/list")
    public YaApiResult<?> queryPage(@RequestBody YaBasePageDto dto) {
        YaPageBean<?> result = weiYanServiceImpl.queryPage(dto.getCurrent(), dto.getSize());
        return YaApiResult.ok(result);
    }


}

