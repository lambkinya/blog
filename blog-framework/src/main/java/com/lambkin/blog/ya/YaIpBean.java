package com.lambkin.blog.ya;

import lombok.Data;

import java.time.LocalDate;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-24 18:01:34
 */
@Data
public class YaIpBean {

    private String ip;

    private String country;

    private String province;

    private String city;

    private LocalDate visitDate;
}
