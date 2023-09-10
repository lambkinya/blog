package com.lambkin.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambkin.blog.domain.ArticleEntity;
import com.lambkin.blog.dao.ArticleMapper;
import com.lambkin.blog.service.IArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>文章表--Article</p>
 *
 * @author lambkinya
 * @since 2023-09-10 03:57:14
 */
@Service("iArticleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements IArticleService {

}

