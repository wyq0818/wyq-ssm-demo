package com.wyq.cloud.producer.util.druid;

/*
 * @Author:wuyongqiang
 * @Date:2020-12-16 09:47:9:47
 */
import org.apache.tomcat.util.codec.binary.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AesHope工具类
 *
 * @author: gourd
 *
 **/
public class AesHopeUtil {
    private static final String KEY_ALGORITHM = "AES";
    //默认的加密算法
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /***
     * AES加密
     * @param password
     * @param content
     * @return
     * @throws Exception
     * 返回Base64转码后的加密数据
     */
    public static String encrypt(String password, String content){
        //创建密码器
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] bytes = content.getBytes("utf-8");
            //初始化密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKeySpec(password));
            //加密
            byte[] bytes1 = cipher.doFinal(bytes);
            //通过BASE64转码返回
            return Base64.encodeBase64String(bytes1);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * AES解密
     * @param password
     * @param content
     * @return
     * @throws Exception
     */
    public static String decryt(String password, String content) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化解密
            cipher.init(Cipher.DECRYPT_MODE, getSecretKeySpec(password));
            byte[] bytes = cipher.doFinal(Base64.decodeBase64(content));
            return new String(bytes, "utf-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 生成加密密钥
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static SecretKeySpec getSecretKeySpec(final String password)  {
        //返回密钥生成器对象
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            //设置AES密钥长度
            keyGenerator.init(128, secureRandom);
            //生成一个密钥
            SecretKey secretKey = keyGenerator.generateKey();
            //转换为AES密钥
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
