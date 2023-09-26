package com.lambkin.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>博客 - 后台管理端</p>
 *
 * @author lambkinya
 * @since 2023-09-24 18:32:19
 */
@SpringBootApplication
@MapperScan("com.lambkin.blog.dao")
@ComponentScan({"com.lambkin.blog.config", "com.lambkin.blog.web", "com.lambkin.blog.service.impl", "com.lambkin.blog.service.query"})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
