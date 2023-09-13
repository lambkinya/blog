package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambkin.blog.constant.BlogConstant;
import com.lambkin.blog.dao.ArticleMapper;
import com.lambkin.blog.dao.CategoryMapper;
import com.lambkin.blog.domain.ArticleEntity;
import com.lambkin.blog.domain.CategoryEntity;
import com.lambkin.blog.model.ArticleListVo;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import com.lambkin.blog.ya.YaPageBean;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.function.Function;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-10 21:24:19
 */
@Component
public class ArticleQuery {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private CategoryMapper categoryMapper;


    public ArticleEntity queryDetailByNo(String no) {
        return articleMapper.selectOne(
                new LambdaQueryWrapper<ArticleEntity>().eq(ArticleEntity::getNo, no)
        );
    }

    public List<ArticleEntity> queryList() {
         return articleMapper.selectList(null);
    }

    public YaPageBean<?> queryPage(Integer pageNo, Integer pageSize, String categoryNo) {
        Page<ArticleEntity> entityPage = articleMapper.selectPage(
                new Page<ArticleEntity>(pageNo, pageSize),
                new LambdaQueryWrapper<ArticleEntity>()
                        .eq(ArticleEntity::getStatus, BlogConstant.ARTICLE_STATUS_PUBLIC)
                        .eq(StringUtils.hasText(categoryNo), ArticleEntity::getCategoryNo, categoryNo)
                        .orderByDesc(ArticleEntity::getIsTop)
        );

        List<ArticleListVo> records = entityPage.getRecords().stream().map(new Function<ArticleEntity, ArticleListVo>() {
            @Override
            public ArticleListVo apply(ArticleEntity entity) {
                ArticleListVo vo = YaBeanCopyUtil.copyBean(entity, ArticleListVo.class);
                CategoryEntity categoryEntity = categoryMapper.selectOne(
                        new LambdaQueryWrapper<CategoryEntity>()
                                .eq(CategoryEntity::getNo, entity.getCategoryNo())
                );
                vo.setCategoryName(categoryEntity.getName());
                return vo;
            }
        }).toList();

        return YaPageBean.build(entityPage, records);
    }

    public YaPageBean<?> queryDesc(Integer pageNo, Integer pageSize) {
        Page<ArticleEntity> entityPage = articleMapper.selectPage(
                new Page<ArticleEntity>(pageNo, pageSize),
                new LambdaQueryWrapper<ArticleEntity>()
                        .eq(ArticleEntity::getStatus, BlogConstant.ARTICLE_STATUS_PUBLIC)
                        .orderByDesc(ArticleEntity::getCreateTime)
        );

        return YaPageBean.build(entityPage, ArticleListVo.class);
    }
}
