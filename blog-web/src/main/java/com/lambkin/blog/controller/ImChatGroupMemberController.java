package com.lambkin.blog.controller;

import com.lambkin.blog.service.IImChatGroupMemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 聊天群成员表 前端控制器
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/im_chat_group_member")
public class ImChatGroupMemberController {

    @Resource
    private IImChatGroupMemberService imChatGroupMemberServiceImpl;



}
