package com.lambkin.blog.ya;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-10 10:56:16
 */
public class YaBeanNoUtil {

    private static final String DATA_PATTERN = "yyMMddHHmm ss";

    public static String generateNo(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word)
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATA_PATTERN)));
        Integer randomInt = (new Random()).nextInt(9999);
        String random = (new DecimalFormat("0000")).format(randomInt);
        sb.append(random);
        return sb.toString().replaceAll(" +","");
    }
}
