package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.entity.CommentEntity;
import com.lambkin.blog.mapper.CommentMapper;
import com.lambkin.blog.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 评论表 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentEntity> implements ICommentService {

}
