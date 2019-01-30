package com.hdrtrr.jmh.utils.response;

import java.io.Serializable;

/**
 * @Author hdrtrr jmh
 * @Date 2019/1/28 0028  下午 4:07
 * @Version 1.0
 */
public class FailedResponse implements Response, Serializable {
    private static final long serialVersionUID = 8596873414025917770L;

    /**
     * 返回的状态码
     */
    private String status;
    /**
     * 返回的消息
     */
    private String message;


    /**
     * 默认构造方法，status为'500'，消息为'failed'
     */
    public FailedResponse() {
        this.status = CODE_FAILED;
        this.message = MSG_FAILED;
    }

    /**
     * 自定义返回消息的构造方法，status为`500`
     *
     * @param message 消息
     */
    public FailedResponse(String message) {
        this.message = message;
        this.status = CODE_FAILED;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "FailedResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
