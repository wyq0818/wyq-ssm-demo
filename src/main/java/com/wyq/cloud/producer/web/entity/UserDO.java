package com.wyq.cloud.producer.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wyq.cloud.producer.component.model.BaseDO;


/*
 * @Author:wuyongqiang
 * @Date:2020-12-23 16:06:16:06
 */
@TableName("user")
public class UserDO extends BaseDO {
    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private int age;

    private String realname;

    private String account;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", realname='" + realname + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
