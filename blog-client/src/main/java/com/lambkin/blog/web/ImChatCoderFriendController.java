package com.lambkin.blog.web;

import com.lambkin.blog.service.IImChatCoderFriendService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>好友表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/imChatCoderFriends")
public class ImChatCoderFriendController {

    @Resource
    private IImChatCoderFriendService imChatCoderFriendServiceImpl;

}

