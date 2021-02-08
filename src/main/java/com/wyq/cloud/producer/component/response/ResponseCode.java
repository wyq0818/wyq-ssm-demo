package com.wyq.cloud.producer.component.response;

/*
 * @Author:wuyongqiang
 * @Date:2021-02-01 14:52:14:52
 */
/**
 *
 * 返回状态的枚举
 */
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    SELLER_NEED_LOGIN(11,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    Exception(-1,"Exception");

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
