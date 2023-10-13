package com.lambkin.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 查询 ES 请求体
 *
 * @author lambkinya
 * @since 2023-10-12 09:06:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchForEsRequest implements Serializable {

    private String searchText;
    private long pageNum;
    private long pageSize;
}
