package com.lambkin.blog.ya;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.gson.io.GsonSerializer;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-13 15:15:14
 */
public class YaJwtUtil {

    /**
     * token默认有效时间 60 * 60 *1000  一个小时
     */
    private static final Long JWT_TTL = 24*60 * 60 *1000L;

    /**
     * 秘钥明文
     */
    private static final String JWT_KEY = "jinan_20220511jinan_20220511jinan_20220511jinan_20220511";


    /**
     * 生成jtw
     * @param subject token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return token
     */
    public static String build(String subject, Long ttlMillis) {
        Map<String, Object> claims = new HashMap<>();

        long nowMillis = System.currentTimeMillis();
        if(ttlMillis==null){
            ttlMillis=YaJwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        claims.put("exp", expMillis);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setExpiration(new Date(expMillis))
                .signWith(generalKey(),SignatureAlgorithm.HS256)
                .serializeToJsonWith(new GsonSerializer<>(new Gson()))
                .compact();
    }

    /**
     * 生成jtw
     * @param subject token中要存放的数据（json格式）
     * @return token
     */
    public static String build(String subject) {
        Map<String, Object> claims = new HashMap<>();

        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + YaJwtUtil.JWT_TTL;
        claims.put("exp", expMillis);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setExpiration(new Date(expMillis))
                .signWith(generalKey(),SignatureAlgorithm.HS256)
                .serializeToJsonWith(new GsonSerializer<>(new Gson()))
                .compact();
    }


    /**
     * 生成加密后的秘钥 secretKey
     * @return javax.crypto.SecretKey
     */
    private static SecretKey generalKey() {
        byte[] encodedKey = Base64.decodeBase64(YaJwtUtil.JWT_KEY);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA256");
    }

    /**
     * 解析
     *
     * @param str token
     * @return
     * @throws Exception
     */
    public static Claims parse(String str) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(str)
                .getBody();
    }
}
