package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lambkin.blog.dao.CategoryMapper;
import com.lambkin.blog.domain.CategoryEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-11 11:46:50
 */
@Component
public class CategoryQuery {

    @Resource
    private CategoryMapper categoryMapper;


    public CategoryEntity queryByNo(String categoryNo) {
        return categoryMapper.selectOne(
                new LambdaQueryWrapper<CategoryEntity>().eq(CategoryEntity::getNo, categoryNo)
        );
    }

    public List<CategoryEntity> queryListByNo(String categoryNo) {
//        return categoryMapper.selectList(new LambdaQueryWrapper<CategoryEntity>().eq(
//                CategoryEntity::getParentNo, StringUtils.hasText(categoryNo) ? categoryNo : BlogConstant.ROOT_CATEGORY
//        ));
        return null;
    }

    public List<CategoryEntity> queryList() {
         return categoryMapper.selectList(null);
    }
}
