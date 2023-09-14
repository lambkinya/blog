package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lambkin.blog.dao.TagMapper;
import com.lambkin.blog.domain.TagEntity;
import com.lambkin.blog.model.TagVo;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-14 20:52:01
 */
@Component
public class TagQuery {

    @Resource
    private TagMapper tagMapper;

    public List<TagVo> queryByNos(List<String> tagNoList) {
        List<TagEntity> tagEntityList = tagMapper.selectList(
                new LambdaQueryWrapper<TagEntity>().in(TagEntity::getNo, tagNoList)
        );

        return YaBeanCopyUtil.copyBeanList(tagEntityList, TagVo.class);
    }
}
