package com.lambkin.blog.model.dto;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-15 01:16:00
 */
@Data
public class PublishCommentDto {

    private String articleNo;

    private String coderNo;

    private String content;

    private Integer type;

    private String rootCommentNo;

    private String toCoderNo;

    private String toCommentNo;

}
