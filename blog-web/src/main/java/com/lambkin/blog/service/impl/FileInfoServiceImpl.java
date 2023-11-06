package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.entity.FileInfoEntity;
import com.lambkin.blog.mapper.FileInfoMapper;
import com.lambkin.blog.service.IFileInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * coder资源信息表 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfoEntity> implements IFileInfoService {

}
