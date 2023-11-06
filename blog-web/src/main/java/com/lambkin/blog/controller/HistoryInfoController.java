package com.lambkin.blog.controller;

import com.lambkin.blog.service.IHistoryInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 历史信息 前端控制器
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@RestController
@RequestMapping("/history_info")
public class HistoryInfoController {

    @Resource
    private IHistoryInfoService historyInfoServiceImpl;



}
