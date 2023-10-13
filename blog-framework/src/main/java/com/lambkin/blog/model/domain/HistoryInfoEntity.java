package com.lambkin.blog.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>历史信息--entity</p>
 *
 * @author lambkinya
 * @since 2023-09-17 13:25:25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("history_info")
public class HistoryInfoEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 318940467199767593L;

    /**
     * 编号
     */
    private String no;

    /**
     * coder编号
     */
    private String coderNo;

    /**
     * ip
     */
    private String ip;

    /**
     * 国家
     */
    private String nation;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

}


