package com.lambkin.blog.service.impl;

import com.lambkin.blog.domain.TagEntity;
import com.lambkin.blog.model.vo.TagVo;
import com.lambkin.blog.service.ITagService;
import com.lambkin.blog.service.query.TagQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>标签表--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:27
 */
@Service("iTagService")
public class TagServiceImpl implements ITagService {

    @Resource
    private TagQuery tagQuery;


    @Override
    public List<TagVo> queryTagListAdmin() {
        List<TagEntity> tagEntityList = tagQuery.queryList();

        return YaBeanCopyUtil.copyBeanList(tagEntityList, TagVo.class);
    }
}

