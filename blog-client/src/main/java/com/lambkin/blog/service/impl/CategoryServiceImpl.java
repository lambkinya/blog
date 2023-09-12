package com.lambkin.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambkin.blog.domain.CategoryEntity;
import com.lambkin.blog.dao.CategoryMapper;
import com.lambkin.blog.model.CategoryListVo;
import com.lambkin.blog.service.ICategoryService;
import com.lambkin.blog.service.query.CategoryQuery;
import com.lambkin.blog.ya.YaApiResult;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>分类表--Category--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-10 10:40:57
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryQuery categoryQuery;


    @Override
    public List<?> queryList(String categoryNo) {
        List<CategoryEntity> categoryEntityList = categoryQuery.queryListByNo(categoryNo);

        return YaBeanCopyUtil.copyBeanList(categoryEntityList, CategoryListVo.class);
    }
}

