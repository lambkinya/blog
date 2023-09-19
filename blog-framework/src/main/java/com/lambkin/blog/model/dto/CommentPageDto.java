package com.lambkin.blog.model.dto;

import com.lambkin.blog.ya.YaBasePageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-18 13:50:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommentPageDto extends YaBasePageDto {

    private Integer type;

    private String articleNo;
}
