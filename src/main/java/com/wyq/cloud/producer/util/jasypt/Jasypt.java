package com.wyq.cloud.producer.util.jasypt;

import org.jasypt.util.text.BasicTextEncryptor;

/*
 * @Author:wuyongqiang
 * @Date:2020-12-16 10:55:10:55
 */
public class Jasypt {
    public static void main(String[] args) throws Exception {
        // jasypt
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("GOURD-HXN-1314");
        // 加密
        String password = textEncryptor.encrypt("root");
        System.out.println("^0^===password:"+ password);
        // 解密
        String originPwd = textEncryptor.decrypt("MKCeZ1FaCJ3Ryd10y+/02Q==");
        System.out.println("^0^===originPwd:"+ originPwd);
    }
}
