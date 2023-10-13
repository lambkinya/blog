package com.lambkin.blog.ya;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Bean 操作类
 *
 * @author lambkinya
 * @since 2023-09-09 23:02:55
 */
public class YaBeanUtils {

    private static final String DATA_PATTERN = "yyMMddHHmm ss";


    public static String generateNo(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word)
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATA_PATTERN)));
        Integer randomInt = (new Random()).nextInt(9999);
        String random = (new DecimalFormat("0000")).format(randomInt);
        sb.append(random);
        return sb.toString().replaceAll(" +", "");
    }

    public static <V> V copyBean(Object source, Class<V> clazz) {
        //创建目标对象
        V result = null;
        try {
            result = clazz.getDeclaredConstructor().newInstance();
            //实现属性copy
            org.springframework.beans.BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }

    public static <K, V> List<V> copyBeanList(List<K> list, Class<V> clazz) {
        return list.stream()
                .map(item -> copyBean(item, clazz))
                .collect(Collectors.toList());
    }

}
