package com.lambkin.blog.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-10 19:32:53
 */
@JsonComponent
@Configuration
public class JacksonCustomizerConfig {

    private static final String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String LOCAL_DATE_PATTERN = "yyyy-MM-dd";

    private static final String LOCAL_TIME_PATTERN = "HH:mm:ss";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN)));
            builder.serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN)));
            builder.serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN)));
            builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN)));
            builder.deserializerByType(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN)));
            builder.deserializerByType(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN)));
        };
    }

    /**
     * 时间LocalDateTime转换
     */
    @Component
    public static class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

        @Override
        public LocalDateTime convert(String source) {
            if (!StringUtils.hasText(source)) {
                return null;
            }
            if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
            throw new IllegalArgumentException("Invalid value '" + source + "'");
        }
    }

    /**
     * 时间LocalDate转换
     */
    @Component
    public static class LocalDateConverter implements Converter<String, LocalDate> {
        @Override
        public LocalDate convert(String source) {
            if (!StringUtils.hasText(source)) {
                return null;
            }
            if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            throw new IllegalArgumentException("Invalid value '" + source + "'");
        }
    }
}
