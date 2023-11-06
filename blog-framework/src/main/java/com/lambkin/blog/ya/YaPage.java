package com.lambkin.blog.ya;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义分页信息
 *
 * @author lambkinya
 * @since 2023-09-10 19:43:04
 */
@Slf4j
@Data
@NoArgsConstructor
public class YaPage<E> implements Serializable {

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
     * @param iPage 数据库返回的分页信息
     * @param <K>   数据库返回的实体类
     * @return 返回给前端的分页信息
     */
    public static <K> YaPage<K> build(IPage<K> iPage) {
        YaPage<K> pageRes = new YaPage<>();
        BeanUtils.copyProperties(iPage, pageRes);
        return pageRes;
    }

    /**
     * 在应用方法内提前构造recordList，这里直接赋值
     *
     * @param iPage   数据库返回的分页信息
     * @param objList 提前构造好的 list 数据
     * @param <K>     数据库返回的实体类
     * @param <T>     脱敏后的实体类
     * @return 返回给前端的分页信息
     */
    public static <K, T> YaPage<T> build(IPage<K> iPage, List<T> objList) {
        YaPage<T> pageRes = new YaPage<>();
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
     * @param iPage 数据库返回的分页信息
     * @param cls   脱敏后的实体类 类型
     * @param <K>   数据库返回的实体类
     * @param <T>   脱敏后的实体类
     * @return 返回给前端的分页信息
     */
    public static <K, T> YaPage<T> build(IPage<K> iPage, Class<T> cls) {
        if (CollectionUtils.isEmpty(iPage.getRecords())) {
            return build(iPage, cls);
        }
        List<T> objList = new ArrayList<>();
        for (Object e : iPage.getRecords()) {
            T o = null;
            try {
                o = cls.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e1) {
                log.error("pageRes error1", e1);
            } catch (IllegalAccessException e2) {
                log.error("pageRes error2", e2);
            } catch (InvocationTargetException | NoSuchMethodException e3) {
                log.error("pageRes error3", e3);
            }
            if (o != null) {
                BeanUtils.copyProperties(e, o);
            }
            objList.add(o);
        }
        return build(iPage, objList);
    }
}
