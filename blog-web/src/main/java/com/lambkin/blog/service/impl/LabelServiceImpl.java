package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.entity.LabelEntity;
import com.lambkin.blog.mapper.LabelMapper;
import com.lambkin.blog.service.ILabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 标签表 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, LabelEntity> implements ILabelService {

}
