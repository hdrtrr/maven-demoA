package com.hdrtrr.jmh.user.controller;

import com.hdrtrr.jmh.entity.User;
import com.hdrtrr.jmh.user.service.UserSeachService;
import com.hdrtrr.jmh.utils.response.Response;
import org.springframework.web.bind.annotation.*;


/**
 * @Author hdrtrr jmh
 * @Date 2019/1/28 0028  下午 3:39
 * @Version 1.0
 */

@CrossOrigin
@RequestMapping("/user/")
@RestController
public class UserSearch {


    private final UserSeachService userSeachService;

    public UserSearch(UserSeachService userSeachService) {
        this.userSeachService = userSeachService;
    }

    /**
     * 用户查询
     * @return
     */
    @RequestMapping(value = "search",method = {RequestMethod.GET,RequestMethod.POST})
    public Response search() {
        return userSeachService.search();
    }

    /**
     * 单个用户新增
     * @return
     */
    @RequestMapping(value = "addOne",method = {RequestMethod.GET,RequestMethod.POST})
    public Response addOne(@RequestBody User user) {
        return userSeachService.addOne(user);
    }
}
