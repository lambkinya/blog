package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.entity.EssayEntity;
import com.lambkin.blog.mapper.EssayMapper;
import com.lambkin.blog.service.IEssayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 随笔表 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class EssayServiceImpl extends ServiceImpl<EssayMapper, EssayEntity> implements IEssayService {

}
