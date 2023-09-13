package com.lambkin.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-11 22:44:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogInfoVo {

    private Integer articleCount;
    private Integer categoryCount;
    private Integer tagCount;
    private Integer viewCount;
    private SiteConfig siteConfig;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SiteConfig {
        private Integer id;
        private String userAvatar;
        private String touristAvatar;
        private String siteName;
        private String siteAddress;
        private String siteIntro;
        private String siteNotice;
        private LocalDate createSiteTime;
        private String recordNumber;
        private String authorAvatar;
        private String siteAuthor;
        private String articleCover;
        private String aboutMe;
        private String github;
        private String gitee;
        private String bilibili;
        private String qq;
        private Integer commentCheck;
        private Integer messageCheck;
        private Integer isReward;
        private String weiXinCode;
        private String aliCode;
        private Integer emailNotice;
        private String socialList;
        private String loginList;
        private Integer isMusic;
        private String musicId;
        private Integer isChat;
        private String websocketUrl;
    }
}
