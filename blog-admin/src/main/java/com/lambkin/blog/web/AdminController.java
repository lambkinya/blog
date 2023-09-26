package com.lambkin.blog.web;

import com.lambkin.blog.ya.YaApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-24 18:34:26
 */
@RestController
@RequestMapping
public class AdminController {


    @GetMapping("/test")
    public YaApiResult<?> test() {

        return YaApiResult.ok();
    }

}
