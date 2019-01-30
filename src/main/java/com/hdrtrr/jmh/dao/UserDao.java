package com.hdrtrr.jmh.dao;

import com.hdrtrr.jmh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author hdrtrr jmh
 * @Date 2019/1/28 0028  下午 3:33
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor <User>{
}
