package com.hdrtrr.jmh.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/15 0028  上午 10:50
 * @Version 1.0
 */

@Entity
@Table(name = "organizition")
public class Organizition {
    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    private String id;

    /**
     * 组织编码
     */
    @Column(name="org_code")
    private String orgCode;

    /**
     * 组织姓名
     */
    @Column(name="org_name")
    private String orgName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
