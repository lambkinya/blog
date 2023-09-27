package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.service.IImChatGroupMemberService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>聊天群成员表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/imChatGroupMembers")
public class ImChatGroupMemberController {

    @Resource
    private IImChatGroupMemberService imChatGroupMemberServiceImpl;

}

