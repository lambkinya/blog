package com.lambkin.blog.service;

import com.lambkin.blog.model.vo.TagVo;

import java.util.List;

/**
 * <p>标签表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:27
 */
public interface ITagService {

    List<TagVo> queryTagListAdmin();
}

