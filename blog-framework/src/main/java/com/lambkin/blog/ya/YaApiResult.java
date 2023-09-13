package com.lambkin.blog.ya;

import java.io.Serializable;

/**
 * @author lambkinya
 * @since 2023-09-09 22:43:27
 */
public class YaApiResult<T> implements Serializable {

    private Boolean flag;
    private Integer code;
    private String msg;
    private T data;

    public YaApiResult() {
        this.code = YaApiCodeEnum.SUCCESS.getCode();
        this.msg = YaApiCodeEnum.SUCCESS.getMsg();
    }

    public YaApiResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public YaApiResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public YaApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static YaApiResult<?> error(int code, String msg) {
        YaApiResult<?> result = new YaApiResult<>();
        result.setFlag(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static YaApiResult<?> error(YaApiCodeEnum codeEnum) {
        YaApiResult<?> result = new YaApiResult<>();
        result.setFlag(false);
        result.setCode(codeEnum.getCode());
        result.setMsg(codeEnum.getMsg());
        return result;
    }

    public static YaApiResult<?> okResult() {
        YaApiResult<?> result = new YaApiResult<>();
        result.setCode(YaApiCodeEnum.SUCCESS.getCode());
        result.setMsg(YaApiCodeEnum.SUCCESS.getMsg());
        result.setFlag(true);
        return result;
    }
    public static YaApiResult<?> okResult(int code, String msg) {
        YaApiResult<?> result = new YaApiResult<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <V> YaApiResult<V> okResult(V data) {
        YaApiResult<V> result = new YaApiResult<>();
        if(data!=null) {
            result.setData(data);
        }
        result.setCode(YaApiCodeEnum.SUCCESS.getCode());
        result.setMsg(YaApiCodeEnum.SUCCESS.getMsg());
        result.setFlag(true);
        return result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
