package com.lambkin.blog;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.lambkin.blog.constant.SystemConfigConsts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class WebApplicationTest {

    @Test
    void testAes() {
        String context = "2023++xy";

        // 使用密钥构建 AES
        AES aes = SecureUtil.aes(SystemConfigConsts.CRYPTOJS_KEY.getBytes(StandardCharsets.UTF_8));

        // 加密为16进制表示 d7e82cbc465157a9c9583bb6be7c0667
        String encryptHex = aes.encryptHex(context);
        System.out.println(encryptHex);
        // 解密为字符串
        String decryptStr = SecureUtil.aes(SystemConfigConsts.CRYPTOJS_KEY.getBytes(StandardCharsets.UTF_8)).decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
    }

}