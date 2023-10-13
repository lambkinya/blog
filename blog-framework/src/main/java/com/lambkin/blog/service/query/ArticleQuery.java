package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambkin.blog.dao.ArticleMapper;
import com.lambkin.blog.dao.CategoryMapper;
import com.lambkin.blog.model.domain.ArticleEntity;
import com.lambkin.blog.ya.YaPage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

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

    public YaPage<?> queryPage(Integer pageNo, Integer pageSize, String categoryNo) {
//        Page<ArticleEntity> entityPage = articleMapper.selectPage(
//                new Page<ArticleEntity>(pageNo, pageSize),
//                new LambdaQueryWrapper<ArticleEntity>()
//                        .eq(ArticleEntity::getStatus, BlogConstant.ARTICLE_STATUS_PUBLIC)
//                        .eq(StringUtils.hasText(categoryNo), ArticleEntity::getCategoryNo, categoryNo)
//                        .orderByDesc(ArticleEntity::getIsTop)
//        );
//
//        List<ArticleListVo> records = entityPage.getRecords().stream().map(new Function<ArticleEntity, ArticleListVo>() {
//            @Override
//            public ArticleListVo apply(ArticleEntity entity) {
//                ArticleListVo vo = YaBeanCopyUtil.copyBean(entity, ArticleListVo.class);
//                CategoryEntity categoryEntity = categoryMapper.selectOne(
//                        new LambdaQueryWrapper<CategoryEntity>()
//                                .eq(CategoryEntity::getNo, entity.getCategoryNo())
//                );
//                vo.setCategoryName(categoryEntity.getName());
//                return vo;
//            }
//        }).toList();
//
//        return YaPage.build(entityPage, records);
        return null;
    }

    public YaPage<?> queryDesc(Integer pageNo, Integer pageSize) {
//        Page<ArticleEntity> entityPage = articleMapper.selectPage(
//                new Page<ArticleEntity>(pageNo, pageSize),
//                new LambdaQueryWrapper<ArticleEntity>()
//                        .eq(ArticleEntity::getStatus, BlogConstant.ARTICLE_STATUS_PUBLIC)
//                        .orderByDesc(ArticleEntity::getCreateTime)
//        );
//
//        return YaPage.build(entityPage, ArticleListVo.class);
        return null;
    }

    public IPage<ArticleEntity> queryArticleByConditionPage(String key, String categoryNo, String tagNo, Boolean openRecommend, Long current, Long size) {
        return articleMapper.selectPage(
                new Page<>(current, size),
                new LambdaQueryWrapper<ArticleEntity>()
                        .like(StringUtils.hasText(key), ArticleEntity::getTitle, key)
                        .eq(StringUtils.hasText(categoryNo), ArticleEntity::getCategoryNo, categoryNo)
                        .eq(StringUtils.hasText(tagNo), ArticleEntity::getTagNo, tagNo)
                        .eq(openRecommend, ArticleEntity::getRecommendStatus, 1)
        );
    }

    public Integer countCategoryArticle(String categoryNo) {
        return articleMapper.selectCount(
                new LambdaQueryWrapper<ArticleEntity>().eq(ArticleEntity::getCategoryNo, categoryNo)
        ).intValue();
    }

    public Integer countTagArticle(String tagNo) {
        return articleMapper.selectCount(
                new LambdaQueryWrapper<ArticleEntity>().eq(ArticleEntity::getTagNo, tagNo)
        ).intValue();
    }

    public List<ArticleEntity> queryByNos(List<String> articleNoList) {
        return articleMapper.selectList(
                new LambdaQueryWrapper<ArticleEntity>()
                        .in(ArticleEntity::getNo, articleNoList)
        );
    }
}
