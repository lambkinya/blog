package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.domain.WeiYanEntity;
import com.lambkin.blog.service.IWeiYanService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>微言表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/weiYans")
public class WeiYanController {

    @Resource
    private IWeiYanService weiYanServiceImpl;

}

