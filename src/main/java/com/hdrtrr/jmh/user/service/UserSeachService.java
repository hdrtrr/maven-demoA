package com.hdrtrr.jmh.user.service;

import com.hdrtrr.jmh.dao.UserDao;
import com.hdrtrr.jmh.entity.User;
import com.hdrtrr.jmh.utils.response.FailedResponse;
import com.hdrtrr.jmh.utils.response.ObjectResponse;
import com.hdrtrr.jmh.utils.response.Response;
import com.hdrtrr.jmh.utils.response.SuccessResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        return new ObjectResponse<>(all);
    }

    public Response addOne(User user) {
        user.setCreateDate(LocalDate.now());
        user.setCreateTime(LocalTime.now());
        user.setModifiTime(LocalDateTime.now());
        User save = userDao.save(user);
        if (save != null){
            return new ObjectResponse<>(save);
        }
        return new FailedResponse("操作失败！");
    }
}
