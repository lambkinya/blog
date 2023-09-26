package com.lambkin.blog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-26 21:01:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminCategoryTagVo {

    private List<CategoryVo> categoryList;

    private List<TagVo> tagList;
}
