package com.lambkin.blog.ya;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-10 19:43:04
 */
@Slf4j
@Data
@NoArgsConstructor
public class YaPageBean<E> implements Serializable {

    /**
     * 用户信息总条数
     */
    private Long total;

    /**
     * 当前页码
     */
    private Long current;

    /**
     * 每页用户信息条数
     */
    private Long size;

    /**
     * 用户信息列表
     */
    private List<E> records;

    /**
     * 同类型转换
     *
     * @param iPage
     * @return
     */
    public static <T> YaPageBean<T> build(IPage<T> iPage) {
        YaPageBean pageRes = new YaPageBean();
        BeanUtils.copyProperties(iPage, pageRes);
        return pageRes;
    }

    /**
     * 在应用方法内提前构造recordList，这里直接赋值
     *
     * @param iPage
     * @param objList
     * @param <T>
     * @return
     */
    public static <T> YaPageBean<T> build(IPage iPage, List<T> objList) {
        YaPageBean pageRes = new YaPageBean();
        BeanUtils.copyProperties(iPage, pageRes);
        if (CollectionUtils.isEmpty(iPage.getRecords())) {
            return pageRes;
        }
        pageRes.setRecords(objList);
        return pageRes;
    }

    /**
     * 不同类型，属性包含转换
     *
     * @param iPage
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> YaPageBean<T> build(IPage iPage, Class<T> cls) {
        if (CollectionUtils.isEmpty(iPage.getRecords())) {
            return build(iPage);
        }
        List<T> objList = new ArrayList<>();
        for (Object e : iPage.getRecords()) {
            T o = null;
            try {
                o = cls.newInstance();
            } catch (InstantiationException e1) {
                log.error("pageRes error1", e1);
            } catch (IllegalAccessException e2) {
                log.error("pageRes error2", e2);
            }
            BeanUtils.copyProperties(e, o);
            objList.add(o);
        }
        return build(iPage, objList);
    }
}
