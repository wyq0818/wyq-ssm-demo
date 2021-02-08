package com.wyq.cloud.producer.web.entity;

import com.wyq.cloud.producer.component.model.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <p>
 * 
 * </p>
 *
 * 传输层
 * @author WuYongQiang
 * @since 2020-12-15
 *
 * .参数定义:（注意：@NotEmpty用在集合类上面 ，@NotBlank用在String上面 ， @NotNull用在基本类型上）
 */

@ApiModel(description = "用户信息保存请求对象")
public class UserDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "用户名称")
    @Size(min = 1,max = 32,message = "name属性的长度大于1，小于32")
    @NotBlank(message ="姓名不能为null")
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
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", realname='" + realname + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
