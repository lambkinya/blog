package com.lambkin.blog.common;

import com.lambkin.blog.enums.YaApiCodeEnum;

import java.io.Serializable;

/**
 * @author lambkin-wow
 * @since 2023-09-09 22:43:27
 */
public class YaApiResult<T> implements Serializable {

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

    public static YaApiResult errorResult(int code, String msg) {
        YaApiResult result = new YaApiResult<>();
        return result.error(code, msg);
    }
    public static YaApiResult okResult() {
        YaApiResult result = new YaApiResult<>();
        result.setCode(YaApiCodeEnum.SUCCESS.getCode());
        result.setMsg(YaApiCodeEnum.SUCCESS.getMsg());
        return result;
    }
    public static YaApiResult okResult(int code, String msg) {
        YaApiResult result = new YaApiResult<>();
        return result.ok(code, null, msg);
    }

    public static <V> YaApiResult<V> okResult(V data) {
        YaApiResult<V> result = setYaApiCodeEnum(YaApiCodeEnum.SUCCESS, YaApiCodeEnum.SUCCESS.getMsg());
        if(data!=null) {
            result.setData(data);
        }
        return result;
    }

    public static YaApiResult errorResult(YaApiCodeEnum enums){
        return setYaApiCodeEnum(enums,enums.getMsg());
    }

    public static YaApiResult errorResult(YaApiCodeEnum enums, String msg){
        return setYaApiCodeEnum(enums,msg);
    }

    public static YaApiResult setYaApiCodeEnum(YaApiCodeEnum enums){
        return okResult(enums.getCode(),enums.getMsg());
    }

    private static YaApiResult setYaApiCodeEnum(YaApiCodeEnum enums, String msg){
        return okResult(enums.getCode(),msg);
    }

    public YaApiResult error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public YaApiResult ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public YaApiResult ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public YaApiResult ok(T data) {
        this.data = data;
        return this;
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
}
