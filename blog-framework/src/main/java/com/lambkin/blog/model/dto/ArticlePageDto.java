package com.lambkin.blog.model.dto;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-17 19:23:00
 */
@Data
public class ArticlePageDto {

    private String key;

    private Long current;

    private Long size;

    private String categoryNo;
}
