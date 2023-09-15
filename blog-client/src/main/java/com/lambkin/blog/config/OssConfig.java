package com.lambkin.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-15 16:10:11
 */
@Data
@Component
@ConfigurationProperties(prefix = "oss")
public class OssConfig {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String domainName;
}
