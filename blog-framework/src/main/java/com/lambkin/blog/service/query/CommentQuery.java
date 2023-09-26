package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambkin.blog.dao.CommentMapper;
import com.lambkin.blog.domain.CommentEntity;
import com.lambkin.blog.ya.YaBeanNoUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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

    public IPage<CommentEntity> queryRootCommentPage(String articleNo, Integer type, Long current, Long size) {
        return commentMapper.selectPage(
                new Page<>(current, size),
                new LambdaQueryWrapper<CommentEntity>()
                        .eq(StringUtils.hasText(articleNo), CommentEntity::getArticleNo, articleNo)
                        .eq(CommentEntity::getRootCommentNo, "-1")
                        .eq(type != null, CommentEntity::getType, type)
                        .orderByDesc(CommentEntity::getCreateTime)
        );
    }

    public IPage<CommentEntity> queryChildrenComment(String no, Long current, Long size) {
        return commentMapper.selectPage(
                new Page<>(current, size),
                new LambdaQueryWrapper<CommentEntity>()
                        //TODO 子评论数量根据根评论编号还是回复评论编号
                        .eq(CommentEntity::getRootCommentNo, no)
                        .orderByAsc(CommentEntity::getCreateTime)
        );
    }

    public Integer countCommentTotalByArticleNoOrType(String articleNo, Integer type) {
        return commentMapper.selectCount(
                new LambdaQueryWrapper<CommentEntity>()
                        .eq(StringUtils.hasText(articleNo), CommentEntity::getArticleNo, articleNo)
                        .eq(type != null, CommentEntity::getType, type)
        ).intValue();
    }

    public void add(CommentEntity comment) {
        comment.setNo(YaBeanNoUtil.generateNo("CN"));
        commentMapper.insert(comment);
    }

    public Integer countChildrenComment(String no) {
        return commentMapper.selectCount(
                new LambdaQueryWrapper<CommentEntity>().eq(CommentEntity::getToCommentNo, no)
        ).intValue();
    }

    public IPage<CommentEntity> queryAllCommentAdmin(String sourceNo, String coderNo, Integer type, Long current, Long size) {
        return commentMapper.selectPage(
                new Page<>(current, size),
                new LambdaQueryWrapper<CommentEntity>()
                        .eq(StringUtils.hasText(sourceNo), CommentEntity::getArticleNo, sourceNo)
                        .eq(StringUtils.hasText(coderNo), CommentEntity::getCoderNo, coderNo)
                        .eq(type != null, CommentEntity::getType, type)
                        .orderByDesc(CommentEntity::getCreateTime)
        );
    }
}
