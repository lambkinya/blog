package com.lambkin.blog.web;

import com.lambkin.blog.service.ITreeHoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>树洞表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/treeHoles")
public class TreeHoleController {

    @Resource
    private ITreeHoleService treeHoleServiceImpl;

}

