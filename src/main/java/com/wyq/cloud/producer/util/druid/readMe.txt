druid数据源配置文件加密参考：https://blog.csdn.net/HXNLYW/article/details/98635913

1.预先根据公钥（自定义）生成加密密码，配置在yml文件中
2.实现加解密算法。
3.编写自己的回调类，实现自己的回调逻辑，并配置到yml中

详细内容尽在：com.wyq.boot.util.druid包下

1）yml配置内容如下：
    #密文的密码
    spring.datasource.password=ZqjmOkAzb8D/jlUG8mRmMQ==
    #############druid加密密码 begin#########################
    # 公钥
    spring.datasource.publicKey:GOURD-HXNLYW-201314
    # 启用加密，配置公钥。
    spring.datasource.connection-properties: config.decrypt=true;publicKey=${spring.datasource.publicKey};password=${spring.datasource.password}
    #加密的自定义回调类
    spring.datasource.passwordCallbackClassName: com.wyq.boot.util.druid.DbPasswordCallback
    ####################druid加密密码 end#####################
2）加解密工具类（自定义）：com.wyq.boot.util.druid.AesHopeUtil
3）回调类，实现自己的回调逻辑:com.wyq.boot.util.druid.DbPasswordCallback