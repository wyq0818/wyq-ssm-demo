package com.wyq.cloud.producer.util.druid;

/*
 * @Author:wuyongqiang
 * @Date:2020-12-16 09:57:9:57
 */
import com.alibaba.druid.util.DruidPasswordCallback;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 数据库回调密码解密
 *
 * @author gourd
 *
 */
@Component
public class DbPasswordCallback extends DruidPasswordCallback {

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String password = properties.getProperty("password");
        String publicKey = properties.getProperty("publicKey");
        if (StringUtils.isNotEmpty(password)) {
            try {
                //所以这里的代码是将密码进行解密
                String sourcePassword = AesHopeUtil.decryt(publicKey, password);
                setPassword(sourcePassword.toCharArray());
            } catch (Exception e) {
                setPassword(password.toCharArray());
            }
        }
    }

    /**
     * 生成加密后的密码，放到yml中
     * @param args
     */
    public static void main(String[] args) {
        //密码
        String password = "root";
        //公钥
        String public_key = "GOURD-HXNLYW-201314";
        // 生成加密后的密码，放到yml中
        //加密
        String pwd = AesHopeUtil.encrypt(public_key,password);
        System.out.println("加密后的password为:"+pwd);

        //解密
        String source = AesHopeUtil.decryt(public_key,pwd);
        System.out.println("解密后的password为:"+source);
    }
}