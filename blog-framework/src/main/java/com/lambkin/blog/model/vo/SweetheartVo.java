package com.lambkin.blog.model.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author lambkinya
 * @since 2023-09-17 13:25:27
 */
@Data
public class SweetheartVo {

    /**
     * 编号
     */
    private String no;

    /**
     * coder编号
     */
    private String coderNo;

    /**
     * 背景封面
     */
    private String background;

    /**
     * 男生头像
     */
    private String manAvatar;

    /**
     * 女生头像
     */
    private String womanAvatar;

    /**
     * 男生昵称
     */
    private String manPetName;

    /**
     * 女生昵称
     */
    private String wifePetName;

    /**
     * 相恋时间
     */
    private LocalDate lovingTime;

    /**
     * 倒计时标题
     */
    private String countdownTitle;

    /**
     * 倒计时时间
     */
    private String countdownTime;

    /**
     * 祝福数量
     */
    private Integer blessingCount;

    /**
     * 额外信息
     */
    private String otherInfo;

}


