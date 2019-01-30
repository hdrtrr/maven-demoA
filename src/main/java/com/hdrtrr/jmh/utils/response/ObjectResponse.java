package com.hdrtrr.jmh.utils.response;

import java.io.Serializable;

/**
 * @Author hdrtrr jmh
 * @Date 2019/1/28 0028  下午 4:06
 * @Version 1.0
 */
public class ObjectResponse<T> implements Response, Serializable {
    private static final long serialVersionUID = 8069880023080117346L;
    /**
     * 返回的状态码
     */
    private String status;
    /**
     * 消息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 只传数据对象 T 的构造方法，其中的状态码为‘200’，消息为‘success’
     *
     * @param data 要返回的数据对象
     */
    public ObjectResponse(T data) {
        this.status = CODE_SUCCESS;
        this.message = MSG_SUCCESS;
        this.data = data;
    }

    /**
     * 自定义返回结果
     *
     * @param status  状态码
     * @param message 消息
     * @param data    数据对象
     */
    public ObjectResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ObjectResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
