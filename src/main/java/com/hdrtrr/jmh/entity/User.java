package com.hdrtrr.jmh.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author hdrtrr jmh
 * @Date 2019/1/28 0028  下午 3:28
 * @Version 1.0
 */

@Entity
@Table(name = "sys_user")
public class User {
    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    private String id;

    /**
     * 姓名
     */
    @Column(name="name")
    private String name;

    /**
     * 性别
     */
    @Column(name="sex")
    private String sex;

    /**
     * 组织机构id
     */
//    @Column(name="organization_id")
    @ManyToOne
    @JoinColumn(name = "organizationId")
    private Organizition organizition;


    /**
     * 创建日期
     */
    @Column(name="create_date")
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate createDate;

    /**
     * 创建时间
     */
    @Column(name="create_time")
    @JSONField(format = "HH:mm:ss")
    private LocalTime createTime;

    /**
     * 修改时间
     */
    @Column(name="modifi_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Organizition getOrganizition() {
        return organizition;
    }

    public void setOrganizition(Organizition organizition) {
        this.organizition = organizition;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifiTime() {
        return modifiTime;
    }

    public void setModifiTime(LocalDateTime modifiTime) {
        this.modifiTime = modifiTime;
    }
}
