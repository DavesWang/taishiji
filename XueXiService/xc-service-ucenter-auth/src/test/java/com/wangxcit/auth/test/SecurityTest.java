package com.wangxcit.auth.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SecurityTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //生成一个jwt令牌
    @Test
    public void testCreateJwt(){
        //证书文件
        String key_location = "wangshuai.keystore";
        //密钥库密码
        String keystore_password = "wangxcitkeystore";
        //访问证书路径
        ClassPathResource resource = new ClassPathResource(key_location);
        //密钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(resource, keystore_password.toCharArray());
        //密钥的密码，此密码和别名要匹配
        String keypassword = "wangxcit";
        //密钥别名
        String alias = "xckey";
        //密钥对（密钥和公钥）
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias,keypassword.toCharArray());
        //私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        //定义payload信息
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("id", "123");
        tokenMap.put("name", "mrt");
        tokenMap.put("roles", "r01,r02");
        tokenMap.put("ext", "1");
        //生成jwt令牌
        /*ResourceServerProperties.*/
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(tokenMap), new RsaSigner(aPrivate));
        //取出jwt令牌
        String token = jwt.getEncoded();
        System.out.println("token="+token);

    }
    //获取解析jwt令牌
    @Test
    public void testVerify(){
        //jwt令牌
        String token ="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb21wYW55SWQiOm51bGwsInVzZXJwaWMiOm51bGwsInVzZXJfbmFtZSI6InRlYWNoZXIxMjMiLCJzY29wZSI6WyJhcHAiXSwibmFtZSI6IueOi-W4hSIsInV0eXBlIjoiMTAxMDAyIiwiaWQiOiI0MDI4OTk4MTZhYmEyNjhiMDE2YWJhMzExMjc4MDAwMCIsImV4cCI6MTU1Nzk1NTQ4OSwiYXV0aG9yaXRpZXMiOlsieGNfdGVhY2htYW5hZ2VyX2NvdXJzZV9iYXNlIiwieGNfdGVhY2htYW5hZ2VyX2NvdXJzZV9kZWwiLCJ4Y190ZWFjaG1hbmFnZXJfY291cnNlX2xpc3QiLCJ4Y190ZWFjaG1hbmFnZXJfY291cnNlX3BsYW4iLCJ4Y190ZWFjaG1hbmFnZXJfY291cnNlIiwiY291cnNlX2ZpbmRfbGlzdCIsInhjX3RlYWNobWFuYWdlciIsInhjX3RlYWNobWFuYWdlcl9jb3Vyc2VfbWFya2V0IiwieGNfdGVhY2htYW5hZ2VyX2NvdXJzZV9wdWJsaXNoIiwieGNfdGVhY2htYW5hZ2VyX2NvdXJzZV9hZGQiXSwianRpIjoiZThkMGNmNjMtNTZjNC00NGM3LTljNjctNDllZTc1MDNlMTMxIiwiY2xpZW50X2lkIjoiWGNXZWJBcHAifQ.XLHAxIrCUoInMxLBZQMyCHa23KwNVI3CVsrdfz1ksA03dMLzxe_Vu-d3Ob5A1N_tprQYjPY2n_IRcF3qRJexM7uxPCaTlvjvmkoBGG8qYIoHjItwkMCneXLMRDQ1NxvHSuiSeTXMtyoTrto2u_Nk8jOv3rFXkC-qRXU6-9kZ-8_kLTxbfItLZzs9B8f85t4ZzNfaRcSJZWiZn46EdOkEI6TJ4YYY-vQluqzpCaF-1HNJyR4rybtNZ1lzlGMFfSL1LnCSd9jMeGCS1F_rb-yiBeORfAOR74pTu1D0fu6XJOZkVBP53Vq3AIsFeV4HU0UiUV3utsG4sOPOZjIZkf3J6w";
        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkn7f2omWL6VDNyMPGmvCVXo31yASvGTGPL1Mp400GMt/lsf44dxoCfPw57jz019HnE+XbqngQy2m/4d8cEMhvolfRkwDVtNLFcTyS3q5wJqsN8nkSSLgKB5ob/DK2kvm7RP/hBbw15i/RKF+95fkWwklOMf/jUbpbmuzrUq/6YaqdryaaRXe/JBNizwEQ7jA8y/BVBfLoWRcWWXkK3Z/+5gNeBdd8EeHDjaA/yIvyYUVNMpMpM/USU+o/iud45G1uNXzvXntoqEk3o5U+3lx/9ZlJ1+k0F4WaXmXQkJBSbp7dJmdXp0qUjWUQ7XouvsU2XAJ+B5QTb1K8JqnXrXCvwIDAQAB-----END PUBLIC KEY-----";
        //校验jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));
        //获取jwt原始内容
        String claims = jwt.getClaims();
        System.out.println(claims);
        //jwt令牌
//        String encoded = jwt.getEncoded();
//        System.out.println(encoded);
    }
    //测试Redis
    @Test
    public void testRedis(){
        //定义key
        String key = "user_token:deca9bfd-7d8a-4ace-958a-d19b9a1c0fa6";
        //定义Map
        Map<String,String> mapValue = new HashMap<>();
        mapValue.put("id","101");
        mapValue.put("username","wang");
        String value = JSON.toJSONString(mapValue);
        System.out.println(mapValue);
        //向redis中存储字符串
        stringRedisTemplate.boundValueOps(key).set(value,60, TimeUnit.SECONDS);
        //读取过期时间，已过期返回-2
        Long expire = stringRedisTemplate.getExpire(key);
        //根据key获取value
        String s = stringRedisTemplate.opsForValue().get(key);
        System.out.println(s);
    }
}
