package com.lambkin.blog.web;

import com.lambkin.blog.service.ITagService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>标签表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/tags")
public class TagController {

    @Resource
    private ITagService tagServiceImpl;

}

