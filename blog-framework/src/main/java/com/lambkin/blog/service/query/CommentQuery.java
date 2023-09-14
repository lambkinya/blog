package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambkin.blog.dao.CommentMapper;
import com.lambkin.blog.domain.CommentEntity;
import com.lambkin.blog.model.CommentVo;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import com.lambkin.blog.ya.YaPageBean;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-14 01:20:38
 */
@Component
public class CommentQuery {

    @Resource
    private CommentMapper commentMapper;

    public YaPageBean<CommentVo> queryRootComment(Integer pageNo, Integer pageSize, String articleNo) {
        Page<CommentEntity> entityPage = commentMapper.selectPage(
                new Page<CommentEntity>(pageNo, pageSize),
                new LambdaQueryWrapper<CommentEntity>()
                        .eq(CommentEntity::getArticleNo, articleNo)
                        .eq(CommentEntity::getRootCommentNo, "-1")
                        .orderByDesc(CommentEntity::getCreateTime)
        );

        return YaPageBean.build(entityPage, CommentVo.class);
    }

    public YaPageBean<CommentVo> queryChildrenComment(Integer pageNo, String no) {
        Page<CommentEntity> entityPage = commentMapper.selectPage(
                new Page<CommentEntity>(pageNo, 3),
                new LambdaQueryWrapper<CommentEntity>()
                        .eq(CommentEntity::getRootCommentNo, no)
                        .orderByDesc(CommentEntity::getCreateTime)
        );

        return YaPageBean.build(entityPage, CommentVo.class);
    }

    public Long countArticleComment(String articleNo) {
        Long count = commentMapper.selectCount(
                new LambdaQueryWrapper<CommentEntity>().eq(CommentEntity::getArticleNo, articleNo)
        );

        return count;
    }
}
