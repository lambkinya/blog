package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.domain.CommentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>评论表--Comment--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-14 00:25:58
 */
@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity> {

}

