package com.lambkin.blog.service.impl;

import com.lambkin.blog.dao.CoderMapper;
import com.lambkin.blog.domain.CoderEntity;
import com.lambkin.blog.model.CommentVo;
import com.lambkin.blog.model.dto.AddCommentDto;
import com.lambkin.blog.service.ICommentService;
import com.lambkin.blog.service.query.CoderQuery;
import com.lambkin.blog.service.query.CommentQuery;
import com.lambkin.blog.ya.YaPageBean;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>评论表--Comment--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-14 00:25:58
 */
@Service("iCommentService")
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentQuery commentQuery;
    @Resource
    private CoderQuery coderQuery;


    @Override
    public YaPageBean<CommentVo> queryList(Integer pageNo, Integer pageSize, String articleNo, Integer type) {

        YaPageBean<CommentVo> result = commentQuery.queryRootComment(pageNo, pageSize, articleNo);

        Long count = commentQuery.countArticleComment(articleNo);
        result.setTotal(count);

        List<CommentVo> commentVoList = this.build(result.getRecords(), pageNo, pageSize);
        result.setRecords(commentVoList);

        return result;
    }

    @Override
    public YaPageBean<CommentVo> queryReplyComment(String commentNo, Integer pageNo) {
        YaPageBean<CommentVo> result = commentQuery.queryChildrenComment(pageNo, commentNo);

        result.getRecords().forEach(item -> {
            String replyNo = item.getCoderNo();
            CoderEntity replyCoderEntity = coderQuery.queryByCoderNo(replyNo);
            item.setAvatar(replyCoderEntity.getAvatar());
            item.setNickname(replyCoderEntity.getNickname());
            item.setPageNo(pageNo);
        });

        return result;
    }

    @Override
    public void add(AddCommentDto comment) {
        commentQuery.add(comment);
    }


    private List<CommentVo> build(List<CommentVo> list, Integer pageNo, Integer pageSize) {
        for (CommentVo commentVo : list) {
            String coderNo = commentVo.getCoderNo();
            CoderEntity coderEntity = coderQuery.queryByCoderNo(coderNo);
            commentVo.setAvatar(coderEntity.getAvatar());
            commentVo.setNickname(coderEntity.getNickname());

            YaPageBean<CommentVo> childrenComment = commentQuery.queryChildrenComment(pageNo, commentVo.getNo());

            List<CommentVo> childrenList = childrenComment.getRecords().stream().peek(childrenCommentItem -> {
                String replyNo = commentVo.getCoderNo();
                CoderEntity replyCoderEntity = coderQuery.queryByCoderNo(replyNo);
                childrenCommentItem.setAvatar(replyCoderEntity.getAvatar());
                childrenCommentItem.setNickname(replyCoderEntity.getNickname());
            }).toList();

            commentVo.setChildrenCommentList(childrenList);
            commentVo.setReplyCount(childrenComment.getTotal().intValue());
            commentVo.setPageNo(childrenComment.getCurrent().intValue());
        }

        return list;
    }
}

