package com.lambkin.blog.ya;

import lombok.Getter;

/**
 * 自定义 - 业务异常
 *
 * @author lambkinya
 * @since 2023-10-01 07:55:15
 */
@Getter
public class BusinessException extends RuntimeException {

    private final String code;

    private final String message;

    private final String description;


    public BusinessException(AppErrorCode errorCode) {
        super(errorCode.getMessage());

        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.description = errorCode.getMessage();
    }

    public BusinessException(AppErrorCode errorCode, String description) {
        super(errorCode.getMessage() + " -> " + description);

        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.description = description;
    }

}
