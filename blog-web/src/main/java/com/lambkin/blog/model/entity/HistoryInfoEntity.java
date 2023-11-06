package com.lambkin.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lambkin.blog.ya.BaseBean;
import java.io.Serializable;
import lombok.Data;

import java.io.Serial;

/**
 * 历史信息
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Data
@TableName("history_info")
public class HistoryInfoEntity extends BaseBean {

    @Serial
    private static final long serialVersionUID = 1L;

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
