package com.lambkin.blog.ya;

/**
 * 抛异常工具类
 *
 * @author lambkinya
 * @since 2023-10-09 17:48:03
 */
public class ThrowUtils {

    /**
     * 条件成立则抛异常
     *
     * @param condition        抛异常地判断条件
     * @param runtimeException 实现 RuntimeException 的自定义业务异常
     * @see com.lambkin.blog.ya.BusinessException
     */
    private static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }


    /**
     * 条件成立则抛异常
     *
     * @param condition 抛异常地判断条件
     * @param errorCode 错误码
     * @see com.lambkin.blog.ya.AppErrorCode
     */
    public static void throwIf(boolean condition, AppErrorCode errorCode) {
        throwIf(condition, new BusinessException(errorCode));
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition   抛异常地判断条件
     * @param errorCode   错误码
     * @param description 错误信息的具体描述
     * @see com.lambkin.blog.ya.AppErrorCode
     */
    public static void throwIf(boolean condition, AppErrorCode errorCode, String description) {
        throwIf(condition, new BusinessException(errorCode, description));
    }
}
