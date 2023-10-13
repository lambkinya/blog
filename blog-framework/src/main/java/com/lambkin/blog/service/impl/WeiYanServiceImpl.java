package com.lambkin.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lambkin.blog.model.domain.WeiYanEntity;
import com.lambkin.blog.model.vo.WeiYanPageVo;
import com.lambkin.blog.service.IWeiYanService;
import com.lambkin.blog.service.query.WeiYanQuery;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import com.lambkin.blog.ya.YaPage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>微言表--impl</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:28
 */
@Service("iWeiYanService")
public class WeiYanServiceImpl implements IWeiYanService {

    @Resource
    private WeiYanQuery weiYanQuery;


    @Override
    public YaPage<?> queryPage(String source, Integer type, Long current, Long size) {
        IPage<WeiYanEntity> pageInfo = weiYanQuery.queryPage(source, type, current, size);

        List<WeiYanPageVo> weiYanPageVoList = pageInfo.getRecords().stream().map(
                entity -> YaBeanCopyUtil.copyBean(entity, WeiYanPageVo.class)
        ).toList();

        return YaPage.build(pageInfo, weiYanPageVoList);
    }

    @Override
    public void publish(String coderNo, String content, Boolean isPublic, Integer type) {
        weiYanQuery.save(coderNo, content, isPublic, type);
    }
}

