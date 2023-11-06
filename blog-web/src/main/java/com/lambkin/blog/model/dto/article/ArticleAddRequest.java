package com.lambkin.blog.model.dto.article;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 添加文章 -- 请求参数
 *
 * @author lambkinya
 * @since 2023-10-30 12:29:05
 */
@Data
public class ArticleAddRequest {


    /**
     * Coder编号
     */
    private String coderNo;

    /**
     * 所属分类编号
     */
    @NotBlank(message = "文章分类不能为空")
    private String categoryNo;

    /**
     * 所属标签编号
     */
    @NotBlank(message = "文章标签不能为空")
    private String labelNo;

    /**
     * 标题
     */
    @NotBlank(message = "文章标题不能为空")
    private String title;

    /**
     * 文章内容
     */
    @NotBlank(message = "文章内容不能为空")
    private String content;

    /**
     * 封面
     */
    private String cover;

    /**
     * 是否推荐[0:否，1:是]
     */
    private Boolean recommendStatus;

    /**
     * 是否允许评论 0否，1是
     */
    private Boolean commentStatus;

    /**
     * 文章是否可见 0否，1是
     */
    private Boolean viewStatus;

    /**
     * 提示
     */
    private String tips;

    /**
     * 密码
     */
    private String password;

}
