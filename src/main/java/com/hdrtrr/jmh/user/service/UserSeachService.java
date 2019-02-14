package com.hdrtrr.jmh.user.service;

import com.hdrtrr.jmh.dao.UserDao;
import com.hdrtrr.jmh.entity.User;
import com.hdrtrr.jmh.utils.page.NgData;
import com.hdrtrr.jmh.utils.page.NgPager;
import com.hdrtrr.jmh.utils.page.SearchFilter;
import com.hdrtrr.jmh.utils.response.FailedResponse;
import com.hdrtrr.jmh.utils.response.ObjectResponse;
import com.hdrtrr.jmh.utils.response.Response;
import com.hdrtrr.jmh.utils.specification.DynamicSpecificationUtils;
import com.hdrtrr.jmh.utils.specification.NgTempUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
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

    public NgData<User> search(NgPager pager) {
        List<User> all = userDao.findAll();
//        return new ObjectResponse<>(all);
        Collection<SearchFilter> build = NgTempUtils.buildWhereClause(pager);
        build.add(new SearchFilter("organizationId",SearchFilter.Operator.EQ,"123"));
        return new NgData<>(
                userDao.findAll(DynamicSpecificationUtils.bySearchFilter(build),NgTempUtils.buildPageRequest(pager)),pager
        );
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
