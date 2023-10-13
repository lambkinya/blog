package com.lambkin.blog.dao.es;

import com.lambkin.blog.model.dto.ArticleEsDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 文章 - ES - 模型
 *
 * @author lambkinya
 * @since 2023-10-12 15:16:39
 */
public interface ArticleEsDao extends ElasticsearchRepository<ArticleEsDto, Long> {


}
