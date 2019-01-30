package com.hdrtrr.jmh.utils.response;

import java.io.Serializable;

/**
 * @Author hdrtrr jmh
 * @Date 2019/1/28 0028  下午 4:05
 * @Version 1.0
 */
public class SuccessResponse  implements Response, Serializable {

    private static final long serialVersionUID = 3775771106150242635L;

    /**
     * 返回的状态码
     */
    private String status;
    /**
     * 返回的消息
     */
    private String message;


    /**
     * 默认构造方法，status为'200'，消息为'success'
     */
    public SuccessResponse() {
        this.status = CODE_SUCCESS;
        this.message = MSG_SUCCESS;
    }

    /**
     * 自定义返回消息的构造方法，status为`200`
     *
     * @param message 消息
     */
    public SuccessResponse(String message) {
        this.message = message;
        this.status = CODE_SUCCESS;
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
        return "SuccessResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
