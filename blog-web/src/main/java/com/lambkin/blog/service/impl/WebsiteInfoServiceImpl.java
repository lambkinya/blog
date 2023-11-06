package com.lambkin.blog.service.impl;

import com.lambkin.blog.model.entity.WebsiteInfoEntity;
import com.lambkin.blog.mapper.WebsiteInfoMapper;
import com.lambkin.blog.service.IWebsiteInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 网站信息表 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class WebsiteInfoServiceImpl extends ServiceImpl<WebsiteInfoMapper, WebsiteInfoEntity> implements IWebsiteInfoService {

}
