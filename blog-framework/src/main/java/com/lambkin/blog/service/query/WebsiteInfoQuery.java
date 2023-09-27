package com.lambkin.blog.service.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lambkin.blog.dao.WebsiteInfoMapper;
import com.lambkin.blog.model.domain.WebsiteInfoEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-17 15:12:09
 */
@Component
public class WebsiteInfoQuery {

    @Resource
    private WebsiteInfoMapper websiteInfoMapper;


    public WebsiteInfoEntity queryWebsiteInfo() {
        return websiteInfoMapper.selectOne(
                new LambdaQueryWrapper<WebsiteInfoEntity>()
                        .eq(WebsiteInfoEntity::getName, "Lambkin")
        );
    }
}
