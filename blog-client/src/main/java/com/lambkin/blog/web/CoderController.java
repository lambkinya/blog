package com.lambkin.blog.web;

import com.lambkin.blog.service.ICoderService;
import jakarta.annotation.Resource;
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

}

