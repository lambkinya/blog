package com.lambkin.blog.controller;

import com.lambkin.blog.service.IImChatCoderFriendService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 好友表 前端控制器
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/im_chat_coder_friend")
public class ImChatCoderFriendController {

    @Resource
    private IImChatCoderFriendService imChatCoderFriendServiceImpl;



}
