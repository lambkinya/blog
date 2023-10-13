package com.lambkin.blog.model.request;

import lombok.Data;

/**
 * 发布微信 - 请求模型
 *
 * @author lambkinya
 * @since 2023-10-13 07:54:11
 */
@Data
public class WeiYanPublishRequest {

    private String coderNo;

    private String content;

    private Boolean isPublic;

    private Integer type;
}
