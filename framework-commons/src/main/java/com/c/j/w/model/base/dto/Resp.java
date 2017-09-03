package com.c.j.w.model.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 接口演示
 * @author chenjw
 * @date 2016年9月21日 下午8:19:10
 */
public class Resp<E> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("请求响应状态,参考字典RespStatus")
    private Integer status;
    @ApiModelProperty("消息提示")
    private String message;
    @ApiModelProperty("返回结果")
    private E data;

    public Resp(Integer status, String message, E data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Resp() {
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return status == RespStatus.Success.code;
    }

    @JsonIgnore
    public boolean isFailure() {
        return status != RespStatus.Success.code;
    }

    /**
     * 业务处理成功
     */
    public static <T> Resp<T> success(String message) {
        return success(message, null);
    }

    public static <T> Resp<T> success() {
        return success(null, null);
    }

    /**
     * 业务处理成功
     */
    public static <T> Resp<T> success(T data) {
        return success(null, data);
    }

    public static <T> Resp<T> success(String message, T data) {
        return new Resp(RespStatus.Success.code, message, data);
    }

    /**
     * 业务处理失败
     */
    public static <T> Resp<T> failure(String message) {
        return failure(message, null);
    }

    public static <T> Resp<T> failure(String message, T data) {
        return new Resp(RespStatus.Failure.code, message, data);
    }

    /**
     * 系统异常
     */
    public static <T> Resp<T> error(String error) {
        return new Resp(RespStatus.Error.code, error, null);
    }

    public static <T> Resp<T> set(Integer status, String message, T data) {
        return new Resp(status, message, data);
    }

}
