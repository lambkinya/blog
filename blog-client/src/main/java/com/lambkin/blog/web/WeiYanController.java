package com.lambkin.blog.web;

import com.lambkin.blog.model.request.WeiYanPublishRequest;
import com.lambkin.blog.service.IWeiYanService;
import com.lambkin.blog.ya.ApiResponse;
import com.lambkin.blog.ya.PageRequest;
import com.lambkin.blog.ya.YaPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/list/{source}/{type}")
    public ApiResponse<?> queryPage(@PathVariable String source, @PathVariable Integer type, @RequestBody PageRequest dto) {
        YaPage<?> result = weiYanServiceImpl.queryPage(source, type, dto.getCurrent(), dto.getSize());
        return ApiResponse.ok(result);
    }

    @PostMapping("/publish")
    public ApiResponse<?> publish(@RequestBody WeiYanPublishRequest request) {
        String coderNo = request.getCoderNo();
        String content = request.getContent();
        Boolean isPublic = request.getIsPublic();
        Integer type = request.getType();

        weiYanServiceImpl.publish(coderNo, content, isPublic, type);
        return ApiResponse.ok();
    }

}

