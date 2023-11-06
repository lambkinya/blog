package com.lambkin.blog.controller;

import com.lambkin.blog.service.IImChatSingleMessageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 单聊记录表 前端控制器
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/im_chat_single_message")
public class ImChatSingleMessageController {

    @Resource
    private IImChatSingleMessageService imChatSingleMessageServiceImpl;



}
