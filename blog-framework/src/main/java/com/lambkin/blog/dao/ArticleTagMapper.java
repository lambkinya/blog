package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.domain.ArticleTagEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>文章标签关联表--ArticleTag--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-14 20:49:26
 */
@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTagEntity> {

}

