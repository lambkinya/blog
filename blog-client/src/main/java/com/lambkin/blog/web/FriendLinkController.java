package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.domain.FriendLinkEntity;
import com.lambkin.blog.service.IFriendLinkService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>友链表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/friendLinks")
public class FriendLinkController {

    @Resource
    private IFriendLinkService friendLinkServiceImpl;

}

