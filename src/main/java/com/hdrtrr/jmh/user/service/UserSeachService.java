package com.hdrtrr.jmh.user.service;

import com.hdrtrr.jmh.dao.UserDao;
import com.hdrtrr.jmh.entity.User;
import com.hdrtrr.jmh.utils.response.Response;
import com.hdrtrr.jmh.utils.response.SuccessResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hdrtrr jmh
 * @Date 2019/1/28 0028  下午 3:41
 * @Version 1.0
 */

@Service
public class UserSeachService {

    private final UserDao userDao;

    public UserSeachService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Response search() {
        List<User> all = userDao.findAll();
        return new SuccessResponse("测试连接成功！");
    }
}
