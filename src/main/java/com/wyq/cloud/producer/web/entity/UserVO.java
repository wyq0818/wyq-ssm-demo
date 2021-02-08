package com.wyq.cloud.producer.web.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *展现层
 * @author WuYongQiang
 * @since 2020-12-15
 */
@ApiModel(description = "用户信息对象")
public class UserVO implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "用户年龄")
    private int age;
    @ApiModelProperty(value = "真实姓名")
    private String realname;
    @ApiModelProperty(value = "用户账号")
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
        return "UserVO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", realname='" + realname + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
