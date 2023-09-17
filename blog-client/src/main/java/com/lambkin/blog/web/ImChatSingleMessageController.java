package com.lambkin.blog.web;

import com.lambkin.blog.service.IImChatSingleMessageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>单聊记录表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/imChatSingleMessages")
public class ImChatSingleMessageController {

    @Resource
    private IImChatSingleMessageService imChatSingleMessageServiceImpl;

}

