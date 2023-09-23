package com.lambkin.blog.service;

import com.lambkin.blog.model.vo.TreeHoleVo;

import java.util.List;

/**
 * <p>树洞表--service</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:27
 */
public interface ITreeHoleService {

    List<TreeHoleVo> queryAllMessage();

    TreeHoleVo leaveMessage(String message, String avatar);
}

