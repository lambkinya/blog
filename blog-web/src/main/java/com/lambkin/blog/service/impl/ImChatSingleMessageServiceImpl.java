package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.entity.ImChatSingleMessageEntity;
import com.lambkin.blog.mapper.ImChatSingleMessageMapper;
import com.lambkin.blog.service.IImChatSingleMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 单聊记录表 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class ImChatSingleMessageServiceImpl extends ServiceImpl<ImChatSingleMessageMapper, ImChatSingleMessageEntity> implements IImChatSingleMessageService {

}
