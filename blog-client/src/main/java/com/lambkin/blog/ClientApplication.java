package com.lambkin.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>博客 - 客户端</p>
 *
 * @author lambkinya
 * @since 2023-09-10 00:07:09
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.lambkin.blog.dao")
@ComponentScan({"com.lambkin.blog.config","com.lambkin.blog.web","com.lambkin.blog.service.impl", "com.lambkin.blog.service.query", "com.lambkin.blog.filter", "com.lambkin.blog.support", "com.lambkin.blog.job", "com.lambkin.blog.mail"})
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,args);
    }
}
