package com.lambkin.blog.ya;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author lambkinya
 * @since 2023-10-01 08:11:18
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ApiResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("businessException: " + e.getMessage(), e);
        return ApiResponse.error(e.getCode(), e.getMessage(), e.getDescription());
    }


    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException: ", e);
        return ApiResponse.error(AppErrorCode.SYSTEM_ERROR, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("methodArgumentNotValidException: ", e);
        return ApiResponse.error(AppErrorCode.PARAMS_ERROR, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

}
