package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lambkin.blog.dao.TagMapper;
import com.lambkin.blog.model.domain.TagEntity;
import com.lambkin.blog.model.vo.TagVo;
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

    public TagEntity queryByNo(String tagNo) {
        return tagMapper.selectOne(
                new LambdaQueryWrapper<TagEntity>().eq(TagEntity::getNo, tagNo)
        );
    }

    public List<TagEntity> queryListByCategoryNo(String categoryNo) {
        return tagMapper.selectList(
                new LambdaQueryWrapper<TagEntity>().eq(TagEntity::getCategoryNo, categoryNo)
        );
    }

    public List<TagEntity> queryList() {
        return tagMapper.selectList(null);
    }
}
