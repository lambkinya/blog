package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.domain.ImChatGroupMessageEntity;
import com.lambkin.blog.service.IImChatGroupMessageService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>群聊记录表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/imChatGroupMessages")
public class ImChatGroupMessageController {

    @Resource
    private IImChatGroupMessageService imChatGroupMessageServiceImpl;

}

