package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.entity.ImChatGroupMessageEntity;
import com.lambkin.blog.mapper.ImChatGroupMessageMapper;
import com.lambkin.blog.service.IImChatGroupMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 群聊记录表 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class ImChatGroupMessageServiceImpl extends ServiceImpl<ImChatGroupMessageMapper, ImChatGroupMessageEntity> implements IImChatGroupMessageService {

}
