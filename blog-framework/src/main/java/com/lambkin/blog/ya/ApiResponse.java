package com.lambkin.blog.ya;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应
 *
 * @author lambkinya
 * @since 2023-09-09 22:43:27
 */
@Data
public class ApiResponse<T> implements Serializable {

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     *
     * @see com.lambkin.blog.ya.AppErrorCode
     */
    private String code;

    /**
     * 响应消息，为前端展示
     */
    private String message;

    /**
     * 响应失败时，返回具体错误信息，为用户展示
     */
    private String description;

    /**
     * 响应数据
     */
    private T data;


    private ApiResponse(Boolean yn) {
        if (yn) {
            this.code = AppErrorCode.SUCCESS.getCode();
            this.message = AppErrorCode.SUCCESS.getMessage();
            this.success = true;
        } else {
            this.success = false;
        }
    }


    private ApiResponse(String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }


    public static ApiResponse<?> error(String code, String message, String description) {
        ApiResponse<?> result = new ApiResponse<>(code, message, description);
        result.setSuccess(false);
        return result;
    }

    public static ApiResponse<?> error(AppErrorCode codeEnum) {
        ApiResponse<?> result = new ApiResponse<>(codeEnum.getCode(), codeEnum.getMessage(), codeEnum.getMessage());
        result.setSuccess(false);
        return result;
    }

    public static ApiResponse<?> error(AppErrorCode codeEnum, String description) {
        ApiResponse<?> result = new ApiResponse<>(codeEnum.getCode(), codeEnum.getMessage(), description);
        result.setSuccess(false);
        return result;
    }

    public static ApiResponse<?> ok() {
        return new ApiResponse<>(true);
    }


    public static <V> ApiResponse<V> ok(V data) {
        ApiResponse<V> result = new ApiResponse<>(true);
        result.setData(data);
        return result;
    }
}
