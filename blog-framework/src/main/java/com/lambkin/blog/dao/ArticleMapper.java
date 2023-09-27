package com.lambkin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lambkin.blog.model.domain.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>文章表--mapper</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:24
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {

}

