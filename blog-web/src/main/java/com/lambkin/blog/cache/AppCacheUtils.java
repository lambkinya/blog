package com.lambkin.blog.cache;

import com.lambkin.blog.constant.AccessConsts;
import com.lambkin.blog.model.entity.CoderEntity;
import com.lambkin.blog.ya.AppErrorCode;
import com.lambkin.blog.ya.ThrowUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.InetAddress;
import java.util.Objects;

/**
 * 缓存工具类
 *
 * @author lambkinya
 * @since 2023-10-31 14:07:31
 */
public class AppCacheUtils {

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static void checkEmail() {
        CoderEntity coder = (CoderEntity) AppCache.get(AppCacheUtils.getToken());
        ThrowUtils.throwIf(coder == null, AppErrorCode.NOT_LOGIN);
        ThrowUtils.throwIf(!StringUtils.hasText(coder.getEmail()), AppErrorCode.EMAIL_NOT_BINDING, "需要绑定邮箱后操作...");
    }

    public static String getToken() {
        return AppCacheUtils.getRequest().getHeader(AccessConsts.TOKEN_HEADER);
    }

    public static CoderEntity getCurrentUser() {
        return (CoderEntity)AppCache.get(AppCacheUtils.getToken());
    }

    public static String getUserId() {
        CoderEntity user = (CoderEntity) AppCache.get(AppCacheUtils.getToken());
        return user == null ? null : user.getNo();
    }

    public static String getUsername() {
        CoderEntity user = (CoderEntity) AppCache.get(AppCacheUtils.getToken());
        return user == null ? null : user.getUsername();
    }




    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                    // 根据网卡取本机配置的IP
                    ipAddress = InetAddress.getLocalHost().getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) {
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = null;
        }
        return ipAddress;
    }


    public static int hashLocation(String key, int length) {
        int h = key.hashCode();
        return (h ^ (h >>> 16)) & (length - 1);
    }
}
