package com.lambkin.blog.web;

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
@RequestMapping("/coder")
public class CoderController {

    @Resource
    private ICoderService coderServiceImpl;

}

