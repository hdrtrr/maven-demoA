package com.hdrtrr.jmh.websocket_test.controller;

import com.hdrtrr.jmh.entity.User;
import com.hdrtrr.jmh.utils.response.FailedResponse;
import com.hdrtrr.jmh.utils.response.Response;
import com.hdrtrr.jmh.utils.response.SuccessResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author hdrtrr jmh
 * @Date 2019/2/15 0028  下午 5:19
 * websocket测试
 * @Version 1.0
 */

@CrossOrigin
@RequestMapping("/socket")
@RestController
public class WebsochetTest {
    /**
     * login
     * 用户登录
     * @param request
     * @return
     */

    @RequestMapping("/login")
    public Response login(HttpServletRequest request) {
        System.out.println("===========1=====");
//        if (user.getName() == null){
//            return new FailedResponse("用户不能为空");
//        }
        // 假设用户登录,存储到session中
        request.getSession().setAttribute("WEBSOCKET_USERNAME","abc");
        return new SuccessResponse("登录成功");
    }


    /**
     * 以下为测试登录接口
     */

    /**
     * 第一个用户
     *
     * @param request
     * @return
     */
    @RequestMapping("/chat1")
    public String chat1(HttpServletRequest request) {
        // 假设用户tom登录,存储到session中
        request.getSession().setAttribute("WEBSOCKET_USERNAME", "tom");
        return "chat1";
    }

    /**
     * 第二个用户登录
     *
     * @param request
     * @return
     */
    @RequestMapping("/chat2")
    public String chat2(HttpServletRequest request) {
        // 假设用户jerry登录,存储到session中
        request.getSession().setAttribute("WEBSOCKET_USERNAME", "jerry");
        return "chat2";
    }

    /**
     * 第三个用户登录
     *
     * @param request
     * @return
     */
    @RequestMapping("/chat3")
    public String chat3(HttpServletRequest request) {
        // 假设用户jack登录,存储到session中
        request.getSession().setAttribute("WEBSOCKET_USERNAME", "jack");
        return "chat3";
    }





}
