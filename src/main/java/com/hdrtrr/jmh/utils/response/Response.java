package com.hdrtrr.jmh.utils.response;

/**
 * @Author hdrtrr jmh
 * @Date 2019/1/28 0028  下午 4:02
 * @Version 1.0
 */
public interface Response {
    /**
     * 失败状态码
     */
    String CODE_FAILED = "500";

    /**
     * 失败返回消息
     */
    String MSG_FAILED = "failed";

    /**
     * 成功状态码
     */
    String CODE_SUCCESS = "200";

    /**
     * 成功返回消息
     */
    String MSG_SUCCESS = "success";



    String getStatus();


    String getMessage();
}
