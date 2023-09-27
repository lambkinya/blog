package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.YaBaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.time.LocalDate;

/**
 * <p>恋人表--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sweetheart")
public class SweetheartEntity extends YaBaseBean {

    @Serial
    private static final long serialVersionUID = 259344762864633510L;

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

    /**
     * 是否启用[0:否，1:是]
     */
    private Integer status;

}


