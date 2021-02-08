文本加解密
1) 依赖包
    <dependency>
        <groupId>com.github.ulisesbocchio</groupId>
        <artifactId>jasypt-spring-boot-starter</artifactId>
        <version>1.16</version>
    </dependency>

2）配置秘钥并生成加密文
    yaml配置：
        jasypt:
          encryptor:
            password: GOURD-HXN-1314
  （1）生成秘钥方式一：
        public static void main(String[] args) throws Exception {
          // jasypt
          BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
          textEncryptor.setPassword("GOURD-HXN-1314");
          // 加密
          String password = textEncryptor.encrypt("gourd123");
          System.out.println("^0^===password:"+ password);
          // 解密
          String originPwd = textEncryptor.decrypt("4M6RKeFuZ7OngpmunjkMm/a+W8eCJrsF");
          System.out.println("^0^===originPwd:"+ originPwd);
        }
  （2）生成秘钥方式二：
        在CMD中cd到jar包路径下执行语句（input：明文信息，password：秘钥）：
        java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="hxnlyw123" password=GOURD-HXN-1314 algorithm=PBEWithMD5AndDES

 3) 将OUTPUT内容替换数据库明文密码并加解密函数：
        jasypt:
          encryptor:
            password: GOURD-HXN-1314

        spring:
          datasource:
            # 公钥
            type: com.alibaba.druid.pool.DruidDataSource
            master:
              url: jdbc:mysql://47.103.5.190:3306/gourd?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false
              driver-class-name: com.mysql.cj.jdbc.Driver
              username: root
              password: ENC(4M6RKeFuZ7OngpmunjkMm/a+W8eCJrsF)
            slave:
              url: jdbc:mysql://47.103.5.190:3306/gourd?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false
              driver-class-name: com.mysql.cj.jdbc.Driver
              username: root
              password: ENC(4M6RKeFuZ7OngpmunjkMm/a+W8eCJrsF)


       注：到此配置完成。redis密码、邮件密码都可以用此方式加密