package com.lambkin.blog.model.dto;

import com.lambkin.blog.ya.YaBasePageDto;
import lombok.Data;

/**
 * <p>后台管理系统 - 用户分页列表 - 请求参数</p>
 *
 * @author lambkinya
 * @since 2023-09-27 10:46:45
 */
@Data
public class AdminCoderPageDto extends YaBasePageDto {

    /**
     * 类型 0.admin 1.coder 2.游客
     */
    private Integer type;

    /**
     * 搜索关键字 username or phone
     */
    private String searchKey;

    /**
     * 是否启用[0:否，1:是]
     */
    private Integer status;
}
