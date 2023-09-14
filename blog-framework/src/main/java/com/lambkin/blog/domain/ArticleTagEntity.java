package com.lambkin.blog.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import java.io.Serial;
import lombok.Data;

/**
 * <p>文章标签关联表--ArticleTag--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-14 20:49:26
 */
@Data
@TableName("article_tag")
public class ArticleTagEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = -68672930690716235L;

    
    /**
     * 文章标签关联关系编号
     */
    private String no;
    
    /**
     * 文章编号
     */
    private String articleNo;
    
    /**
     * 标签编号
     */
    private String tagNo;
    
}


