package com.lambkin.blog.ya;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * IP UTIL
 *
 * @author lambkinya
 * @since 2023-09-24 13:20:30
 */
@Slf4j
public class IpUtils {


    /**
     * 字符常量 0
     */
    private static final String ZERO = "0";

    /**
     * UNKNOWN
     */
    private static final String UNKNOWN = "unknown";

    /**
     * 本机 IP - ipv4
     */
    private static final String LOCALHOST_IPV4 = "127.0.0.1";

    /**
     * 本机 IP - ipv4
     */
    private static final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";


    /**
     * 获取客户端请求的 IP 地址
     *
     * @param request jakarta.servlet.http.HttpServletRequest
     * @return 127.0.0.1
     */
    public static String obtainClientIpAddress(HttpServletRequest request) {
        // 获取客户端ip，客户端可能经过代理，也可能没经过代理
        String ip = request.getHeader("x-forwarded-for");
        log.debug("x-forwarded-for ip: " + ip);
        if (ip != null && ip.length() != 0 && !UNKNOWN.equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.contains(",")) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            log.debug("Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.debug("WL-Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.debug("HTTP_CLIENT_IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.debug("HTTP_X_FORWARDED_FOR ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            log.debug("X-Real-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (LOCALHOST_IPV4.equals(ip) || LOCALHOST_IPV6.equals(ip)) {
                try {
                    // 根据网卡读取本机配置的 IP - 内网 IP
                    ip = InetAddress.getLocalHost().getHostAddress();
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
            }
            log.debug("getRemoteAddr ip: " + ip);
        }

        log.debug("----获取客户端的ip: " + ip);
        // 如果没取到ip，返回""
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = "";
        }

        return ip;
    }


    /**
     * 根据iP获取归属地信息
     *
     * @param ip 客户端请求 IP
     * @return com.lambkin.blog.ya.IpBean
     */
    public static IpBean obtainClientLocationByIp(String ip) {
        IpBean location = new IpBean();
        location.setIp(ip);
        try (InputStream inputStream = IpUtils.class.getResourceAsStream("/ip2region.xdb")) {
            byte[] bytes = IoUtil.readBytes(inputStream);
            Searcher searcher = Searcher.newWithBuffer(bytes);
            String region = searcher.search(ip);
            if (StrUtil.isAllNotBlank(region)) {
                // xdb返回格式 国家|区域|省份|城市|ISP，
                // 只有中国的数据绝大部分精确到了城市，其他国家部分数据只能定位到国家，后前的选项全部是0
                String[] result = region.split("\\|");
                System.out.println(Arrays.toString(result));
                location.setCountry(ZERO.equals(result[0]) ? StrUtil.EMPTY : result[0]);
                location.setProvince(ZERO.equals(result[2]) ? StrUtil.EMPTY : result[2]);
                location.setCity(ZERO.equals(result[3]) ? StrUtil.EMPTY : result[3]);
                location.setVisitDate(LocalDate.now());
            }
            searcher.close();
        } catch (Exception e) {
            log.error("ip地址解析异常,error:{}", e);
            return location;
        }
        return location;
    }


}
