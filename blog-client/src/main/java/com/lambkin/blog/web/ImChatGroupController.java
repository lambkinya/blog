package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.domain.ImChatGroupEntity;
import com.lambkin.blog.service.IImChatGroupService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>聊天群--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/imChatGroups")
public class ImChatGroupController {

    @Resource
    private IImChatGroupService imChatGroupServiceImpl;

}

