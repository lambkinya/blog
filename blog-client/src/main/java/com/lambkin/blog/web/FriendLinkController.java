package com.lambkin.blog.web;

import com.lambkin.blog.model.dto.ApplyFriendLinkDto;
import com.lambkin.blog.model.vo.FriendLinkVo;
import com.lambkin.blog.service.IFriendLinkService;
import com.lambkin.blog.ya.YaApiResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/list")
    public YaApiResult<?> queryFriendLinks() {
        List<FriendLinkVo> result = friendLinkServiceImpl.queryFriendLinks();
        return YaApiResult.ok(result);
    }


    @PostMapping("/apply")
    public YaApiResult<?> applyFriendLink(@RequestBody ApplyFriendLinkDto dto) {
        friendLinkServiceImpl.applyFriendLink(dto);
        return YaApiResult.ok();
    }

}

