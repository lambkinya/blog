package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.service.ITagService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>标签--Tag--web</p>
 *
 * @author lambkinya
 * @since 2023-09-14 20:49:26
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private ITagService tagServiceImpl;

}

