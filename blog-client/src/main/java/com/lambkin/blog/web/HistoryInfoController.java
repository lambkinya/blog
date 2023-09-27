package com.lambkin.blog.web;

import jakarta.annotation.Resource;
import com.lambkin.blog.service.IHistoryInfoService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>历史信息--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/historyInfos")
public class HistoryInfoController {

    @Resource
    private IHistoryInfoService historyInfoServiceImpl;

}

