package com.lambkin.blog.job.once;

import com.lambkin.blog.dao.es.ArticleEsDao;
import com.lambkin.blog.model.domain.ArticleEntity;
import com.lambkin.blog.model.dto.ArticleEsDto;
import com.lambkin.blog.service.IArticleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 项目启动后，通过执行 run 方法，同步 MySQL 文章数据到 Elasticsearch
 *
 * @author lambkinya
 * @since 2023-10-12 18:03:40
 */
//@Component
@Slf4j
public class FullSyncPostToEs implements CommandLineRunner {

    @Resource
    private IArticleService articleServiceImpl;

    @Resource
    private ArticleEsDao articleEsDao;

    @Override
    public void run(String... args) {
        List<ArticleEntity> articleEntityList = articleServiceImpl.searchAllInner();
        if (CollectionUtils.isEmpty(articleEntityList)) {
            return;
        }
        List<ArticleEsDto> articleEsDtoList = articleEntityList.stream().map(item -> {
            ArticleEsDto articleEsDto = new ArticleEsDto();
            BeanUtils.copyProperties(item, articleEsDto);
            return articleEsDto;
        }).toList();
        final int pageSize = 500;
        int total = articleEsDtoList.size();
        log.info("FullSyncPostToEs start, total {}", total);
        for (int i = 0; i < total; i += pageSize) {
            int end = Math.min(i + pageSize, total);
            log.info("sync from {} to {}", i, end);
            articleEsDao.saveAll(articleEsDtoList.subList(i, end));
        }
        log.info("FullSyncPostToEs end, total {}", total);
    }
}
