package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.domain.SweetheartEntity;
import com.lambkin.blog.service.ISweetheartService;
import org.springframework.web.bind.annotation.*;

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

}

