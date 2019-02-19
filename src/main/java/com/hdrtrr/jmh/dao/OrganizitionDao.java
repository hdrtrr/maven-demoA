package com.hdrtrr.jmh.dao;

import com.hdrtrr.jmh.entity.Organizition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/15 0028  上午 11:40
 * @Version 1.0
 */
public interface OrganizitionDao extends JpaRepository<Organizition, String>, JpaSpecificationExecutor <Organizition>{
}
