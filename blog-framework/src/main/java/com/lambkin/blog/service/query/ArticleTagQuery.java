package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lambkin.blog.dao.ArticleTagMapper;
import com.lambkin.blog.domain.ArticleTagEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-14 20:51:39
 */
@Component
public class ArticleTagQuery {

    @Resource
    private ArticleTagMapper articleTagMapper;

    public List<String> queryByArticleNo(String no) {
        List<ArticleTagEntity> articleTagEntityList = articleTagMapper.selectList(
                new LambdaQueryWrapper<ArticleTagEntity>().eq(ArticleTagEntity::getArticleNo, no)
        );

        return articleTagEntityList.stream().map(ArticleTagEntity::getTagNo).collect(Collectors.toList());
    }
}
