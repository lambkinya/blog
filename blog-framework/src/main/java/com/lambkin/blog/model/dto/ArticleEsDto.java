package com.lambkin.blog.model.dto;

import com.lambkin.blog.model.domain.ArticleEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文章 - ES 模型
 *
 * @author lambkinya
 * @since 2023-10-12 15:17:43
 */
@Document(indexName = "article")
@Data
public class ArticleEsDto implements Serializable {

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";


    /**
     * id - ES 中数据的唯一索引
     */
    @Id
    private Long id;


    /**
     * no
     */
    private String no;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建者编号
     */
    @Field(name = "coder_no")
    private String coderNo;

    /**
     * 创建时间
     */
    @Field(name = "create_time", index = false, store = true, type = FieldType.Date, format = {}, pattern = DATE_TIME_PATTERN)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Field(name = "update_time", index = false, store = true, type = FieldType.Date, format = {}, pattern = DATE_TIME_PATTERN)
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Integer yn;


    /**
     * 对象转包装类
     *
     * @param articleEntity
     * @return
     */
    public static ArticleEsDto objToDto(ArticleEntity articleEntity) {
        if (articleEntity == null) {
            return null;
        }
        ArticleEsDto articleEsDto = new ArticleEsDto();
        BeanUtils.copyProperties(articleEntity, articleEsDto);
        return articleEsDto;
    }

    /**
     * 包装类转对象
     *
     * @param articleEsDto
     * @return
     */
    public static ArticleEntity dtoToObj(ArticleEsDto articleEsDto) {
        if (articleEsDto == null) {
            return null;
        }
        ArticleEntity articleEntity = new ArticleEntity();
        BeanUtils.copyProperties(articleEsDto, articleEntity);

        return articleEntity;
    }
}
