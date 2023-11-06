package com.lambkin.blog.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.lambkin.blog.ya.BaseBean;
import org.apache.ibatis.annotations.Mapper;


/**
 * 代码生成器
 *
 * @author lambkinya
 * @since 2023-10-30 10:37:28
 */
public class CodeUtil {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/tuor_blog", "root", "2023++xy")
                .globalConfig(builder -> {
                    builder
                            .author("lambkinya") // 设置作者
                            .outputDir("D://code//blog/blog-web//src//main//java") // 指定输出目录
                            .disableOpenDir()
                    ;
                })
                .packageConfig(builder -> {
                    builder.parent("com.lambkin") // 设置父包名
                            .moduleName("blog.code"); // 设置父包模块名
                })
                .strategyConfig(builder -> {
                    builder
                            .mapperBuilder().enableFileOverride().mapperAnnotation(Mapper.class)
                            .serviceBuilder().enableFileOverride()
                            .controllerBuilder().enableFileOverride().enableRestStyle()
                            .entityBuilder().enableFileOverride().versionColumnName("version").logicDeleteColumnName("yn")
                            .addTableFills(new Column("created", FieldFill.INSERT))
                            .addTableFills(new Column("updated", FieldFill.INSERT_UPDATE))
                            .addSuperEntityColumns("id", "create_time", "update_time", "yn")
                            .formatFileName("%sEntity").enableLombok()
                            .superClass(BaseBean.class);
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .templateConfig(builder -> {
                    builder
                            .entity("/template/entity.java")
                            .mapper("/template/mapper.java")
                            .service("/template/service.java")
                            .serviceImpl("/template/serviceImpl.java")
                            .controller("/template/controller.java")
                    ;
                })
                .execute();
    }
}
