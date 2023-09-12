package com.lambkin.blog.ya;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author lambkinya
 * @since 2023-09-09 23:02:55
 */
public class YaBeanCopyUtil {

    private YaBeanCopyUtil() {
    }

    public static <V> V copyBean(Object source,Class<V> clazz) {
        //创建目标对象
        V result = null;
        try {
            result = clazz.getDeclaredConstructor().newInstance();
            //实现属性copy
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }
    public static <K,V> List<V> copyBeanList(List<K> list, Class<V> clazz){
        return list.stream()
                .map(item -> copyBean(item, clazz))
                .collect(Collectors.toList());
    }
}
