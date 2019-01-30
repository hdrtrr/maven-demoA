package com.hdrtrr.jmh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
     * 姓名
     */
    @Column(name="sex")
    private String sex;

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
}
