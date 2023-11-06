package com.lambkin.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 博客 - Web客户端
 *
 * @author lambkinya
 * @since 2023-09-10 00:07:09
 */
@SpringBootApplication
@MapperScan("com.lambkin.blog.mapper")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
