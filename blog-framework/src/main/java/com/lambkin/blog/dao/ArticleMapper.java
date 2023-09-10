package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.domain.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>文章表--Article</p>
 *
 * @author lambkinya
 * @since 2023-09-10 03:52:34
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {

}

