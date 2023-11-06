package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.entity.HistoryInfoEntity;
import com.lambkin.blog.mapper.HistoryInfoMapper;
import com.lambkin.blog.service.IHistoryInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 历史信息 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class HistoryInfoServiceImpl extends ServiceImpl<HistoryInfoMapper, HistoryInfoEntity> implements IHistoryInfoService {

}
