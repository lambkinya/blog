package com.lambkin.blog.controller;

import com.lambkin.blog.service.IFriendLinkService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 友链表 前端控制器
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/friend_link")
public class FriendLinkController {

    @Resource
    private IFriendLinkService friendLinkServiceImpl;



}
