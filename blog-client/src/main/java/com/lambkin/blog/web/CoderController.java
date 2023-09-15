package com.lambkin.blog.web;

import com.lambkin.blog.model.dto.CoderSimpleInfoDto;
import com.lambkin.blog.ya.YaApiResult;
import jakarta.annotation.Resource;
import com.lambkin.blog.service.ICoderService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Coder--Coder--web</p>
 *
 * @author lambkinya
 * @since 2023-09-13 11:17:14
 */
@RestController
@RequestMapping("/coders")
public class CoderController {

    @Resource
    private ICoderService coderServiceImpl;


    @PostMapping("/updateCoderSimpleInfo")
    public YaApiResult<?> updateCoderSimpleInfo(@RequestBody CoderSimpleInfoDto dto) {
        coderServiceImpl.updateCoderSimpleInfo(dto);
        return YaApiResult.okResult();
    }

}

