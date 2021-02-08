package com.wyq.cloud.producer.component.response;

/*
 * @Author:wuyongqiang
 * @Date:2021-02-01 14:50:14:50
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *
 * 返回前端数据封装
 */

//当序列化Json对象时，如果是null的对象，key也会消失
@JsonSerialize
public class Response<T> implements Serializable {

    @ApiModelProperty(value = "响应码")
    private int status;

    @ApiModelProperty(value = "响应消息")
    private String msg;

    @ApiModelProperty(value = "响应实体类型")
    private T data;

    private Response(int status){
        this.status = status;
    }

    private Response(int status,T data){
        this.status = status;
        this.data = data;
    }

    private Response(int status,String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private Response(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return  this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> Response<T> createBySuccess(){
        return new Response<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> Response<T> createBySuccessMessage(String msg){
        return new Response<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> Response<T> createBySuccess(T data){
        return new Response<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> Response<T> createBySuccess(String msg,T data){
        return new Response<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> Response<T> createByError(){
        return new Response<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <T> Response<T> createByErrorMessage(String errorMessage){
        return new Response<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> Response<T> createByIllegalArgument(String errorMessage){
        return new Response<T>(ResponseCode.ILLEGAL_ARGUMENT.getCode(),errorMessage);
    }

    public static <T> Response<T> createByException(String errorMessage){
        return new Response<T>(ResponseCode.Exception.getCode(),errorMessage);
    }

    //需要登录的构造器
    public static <T> Response<T> createByNeedLogin(){
        return new Response<T>(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
    }

    //需要登录的构造器SELLER_NEED_LOGIN
    public static <T> Response<T> createBySellerNeedLogin(){
        return new Response<T>(ResponseCode.SELLER_NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
    }

    public static <T> Response<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new Response<T>(errorCode,errorMessage);
    }

}
