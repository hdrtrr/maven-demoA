package com.hdrtrr.jmh.user.controller;

import com.hdrtrr.jmh.entity.User;
import com.hdrtrr.jmh.user.service.UserSeachService;
import com.hdrtrr.jmh.utils.page.NgData;
import com.hdrtrr.jmh.utils.page.NgPager;
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
     * 组织查询
     * @return
     */
    @RequestMapping(value = "organizition/search",method = {RequestMethod.GET,RequestMethod.POST})
    public Response organizitionSearch() {
        return userSeachService.organizitionSearch();
    }

    /**
     * 用户查询
     * @return
     */
    @RequestMapping(value = "search/{orgId}",method = {RequestMethod.GET,RequestMethod.POST})
    public NgData<User> search(@RequestBody NgPager pager, @PathVariable("orgId") String orgId) {
        return userSeachService.search(pager, orgId);
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
