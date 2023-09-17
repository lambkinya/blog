package com.lambkin.blog.ya;

import java.io.Serializable;

/**
 * @author lambkinya
 * @since 2023-09-09 22:43:27
 */
public class YaApiResult<T> implements Serializable {

    private Boolean flag;
    private Integer code;
    private String message;
    private T data;
    

    private YaApiResult(Boolean yn) {
        if (yn) {
            this.code = YaApiCodeEnum.SUCCESS.getCode();
            this.message = YaApiCodeEnum.SUCCESS.getMsg();
            this.flag = true;
        }else {
            this.flag = false;
        }
    }
    
    private YaApiResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static YaApiResult<?> error(int code, String message) {
        YaApiResult<?> result = new YaApiResult<>(code, message);
        result.setFlag(false);
        return result;
    }

    public static YaApiResult<?> error(YaApiCodeEnum codeEnum) {
        YaApiResult<?> result = new YaApiResult<>(codeEnum.getCode(), codeEnum.getMsg());
        result.setFlag(false);
        return result;
    }

    public static YaApiResult<?> ok() {
        return new YaApiResult<>(true);
    }
    public static YaApiResult<?> ok(int code, String message) {
        YaApiResult<?> result = new YaApiResult<>(code, message);
        result.setFlag(true);
        return result;
    }

    public static <V> YaApiResult<V> ok(V data) {
        YaApiResult<V> result = new YaApiResult<>(true);
        result.setData(data);
        return result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
