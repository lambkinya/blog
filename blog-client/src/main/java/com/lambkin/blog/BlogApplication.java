package com.lambkin.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-10 00:07:09
 */
@SpringBootApplication
@MapperScan("com.lambkin.blog.dao")
@ComponentScan({"com.lambkin.blog.config","com.lambkin.blog.web","com.lambkin.blog.service.impl", "com.lambkin.blog.service.query", "com.lambkin.blog.filter", "com.lambkin.blog.support"})
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class,args);
    }
}
