package com.lambkin.blog.ya;

import lombok.Data;

/**
 * 基础分页请求参数
 *
 * @author lambkinya
 * @since 2023-09-18 11:32:48
 */
@Data
public class PageRequest {

    private Long current;

    private Long pageSize;

}
