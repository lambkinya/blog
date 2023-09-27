package com.lambkin.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lambkin.blog.model.domain.CoderEntity;
import com.lambkin.blog.model.domain.CommentEntity;
import com.lambkin.blog.enums.CommentTypeEnum;
import com.lambkin.blog.model.dto.AdminCommentPageDto;
import com.lambkin.blog.model.dto.CommentPageDto;
import com.lambkin.blog.model.dto.PublishCommentDto;
import com.lambkin.blog.model.vo.AdminCommentPageVo;
import com.lambkin.blog.model.vo.CommentVo;
import com.lambkin.blog.service.ICommentService;
import com.lambkin.blog.service.query.CoderQuery;
import com.lambkin.blog.service.query.CommentQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import com.lambkin.blog.ya.YaPageBean;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>评论表--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
@Service("iCommentService")
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentQuery commentQuery;
    @Resource
    private CoderQuery coderQuery;


    @Override
    public YaPageBean<?> queryCommentByConditionPage(CommentPageDto dto) {
        IPage<CommentEntity> pageInfo = commentQuery.queryRootCommentPage(
                dto.getArticleNo(), dto.getType(), dto.getCurrent(), dto.getSize()
        );

        List<CommentVo> commentVoList = pageInfo.getRecords().stream().map(
                entity -> buildCommentOtherInfo(entity, dto.getCurrent(), dto.getSize())
        ).toList();

        return YaPageBean.build(pageInfo, commentVoList);
    }

    @Override
    public void publishComment(PublishCommentDto dto) {
        commentQuery.add(YaBeanCopyUtil.copyBean(dto, CommentEntity.class));
    }

    @Override
    public Integer countCommentTotalByArticleNoOrType(String articleNo, Integer type) {
        return commentQuery.countCommentTotalByArticleNoOrType(articleNo, type);
    }

    @Override
    public YaPageBean<?> queryCommentByConditionPageAdmin(AdminCommentPageDto dto) {
        IPage<CommentEntity> pageInfo = commentQuery.queryAllCommentAdmin(
                dto.getSourceNo(), dto.getCoderNo(),
                StringUtils.hasText(dto.getType()) ? CommentTypeEnum.descOf(dto.getType()).getCode() : null
                , dto.getCurrent(), dto.getSize()
        );

        List<AdminCommentPageVo> commentPageVos = pageInfo.getRecords().stream().map(entity -> {
            AdminCommentPageVo vo = YaBeanCopyUtil.copyBean(entity, AdminCommentPageVo.class);

            vo.setSourceNo(entity.getArticleNo());
            vo.setType(CommentTypeEnum.codeOf(entity.getType()).getDesc());

            return vo;
        }).toList();

        return YaPageBean.build(pageInfo, commentPageVos);
    }


    private CommentVo buildCommentOtherInfo(CommentEntity entity, Long current, Long size) {

        CommentVo comment = buildCommentCoderInfoAndChildrenTotal(entity);

        IPage<CommentEntity> childrenPageInfo = commentQuery.queryChildrenComment(
                entity.getNo(), current, size
        );
        List<CommentVo> childrenCommentList = childrenPageInfo.getRecords().stream().map(
                this::buildCommentCoderInfoAndChildrenTotal
        ).toList();

        comment.setChildrenCommentList(childrenCommentList);

        return comment;
    }

    private CommentVo buildCommentCoderInfoAndChildrenTotal(CommentEntity entity) {
        CommentVo comment = YaBeanCopyUtil.copyBean(entity, CommentVo.class);
        CoderEntity coderEntity = coderQuery.queryByCoderNo(entity.getCoderNo());
        Integer childrenCommentTotal = commentQuery.countChildrenComment(entity.getNo());

        // 根评论并不存在父评论信息
        if (!"-1".equals(entity.getToCoderNo())) {
            CoderEntity toCoderEntity = coderQuery.queryByCoderNo(entity.getToCoderNo());
            comment.setToCoderName(toCoderEntity.getUsername());
        }

        comment.setCoderName(coderEntity.getUsername());
        comment.setCoderAvatar(coderEntity.getAvatar());
        comment.setChildrenCommentTotal(childrenCommentTotal);

        return comment;
    }
}

