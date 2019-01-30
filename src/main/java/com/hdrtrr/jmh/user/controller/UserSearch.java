package com.hdrtrr.jmh.user.controller;

import com.hdrtrr.jmh.user.service.UserSeachService;
import com.hdrtrr.jmh.utils.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author hdrtrr jmh
 * @Date 2019/1/28 0028  下午 3:39
 * @Version 1.0
 */

@RequestMapping("/user/")
@RestController
public class UserSearch {


    private final UserSeachService userSeachService;

    public UserSearch(UserSeachService userSeachService) {
        this.userSeachService = userSeachService;
    }

    @RequestMapping(value = "search",method = {RequestMethod.GET,RequestMethod.POST})
    public Response search() {
        return userSeachService.search();
    }
}
