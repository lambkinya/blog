package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import lombok.Data;

import java.io.Serial;

/**
 * 文章表
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("article")
public class ArticleEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文章编号
     */
    private String no;

    /**
     * Coder编号
     */
    private String coderNo;

    /**
     * 所属分类编号
     */
    private String categoryNo;

    /**
     * 所属标签编号
     */
    private String labelNo;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 封面
     */
    private String cover;

    /**
     * 访问量
     */
    private Integer viewCount;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 是否推荐[0:否，1:是]
     */
    private Boolean recommendStatus;

    /**
     * 是否允许评论 0否，1是
     */
    private Boolean commentStatus;

    /**
     * 文章状态（0草稿，1.公开，2.仅自己可见，3...）
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

    public ArticleEntity(String no) {
        this.no = no;
    }

    public ArticleEntity() {
    }

}
