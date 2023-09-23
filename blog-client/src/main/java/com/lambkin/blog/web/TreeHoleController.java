package com.lambkin.blog.web;

import com.lambkin.blog.model.dto.LeaveMessageDto;
import com.lambkin.blog.model.vo.TreeHoleVo;
import com.lambkin.blog.service.ITreeHoleService;
import com.lambkin.blog.ya.YaApiResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>树洞表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/treeHoles")
public class TreeHoleController {

    @Resource
    private ITreeHoleService treeHoleServiceImpl;


    @GetMapping("/all")
    private YaApiResult<?> queryAllMessage() {
        List<TreeHoleVo> result = treeHoleServiceImpl.queryAllMessage();
        return YaApiResult.ok(result);
    }


    @PostMapping("/leaveMessage")
    private YaApiResult<?> leaveMessage(@RequestBody LeaveMessageDto dto) {
        TreeHoleVo result = treeHoleServiceImpl.leaveMessage(dto.getMessage(), dto.getAvatar());
        return YaApiResult.ok(result);
    }

}

