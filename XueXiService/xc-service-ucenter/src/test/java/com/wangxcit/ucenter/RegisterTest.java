package com.wangxcit.ucenter;

import com.wangxcit.framework.domain.ucenter.XcUser;
import com.wangxcit.ucenter.dao.XcUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class RegisterTest {
    @Autowired
    XcUserRepository xcUserRepository;
    @Test
    public void register(){
        XcUser xcUser = new XcUser();
        xcUser.setUsername("test111");
        xcUser.setName("测试一号");
        xcUser.setPassword(new BCryptPasswordEncoder().encode("999999"));
        xcUser.setUtype("101002");
        xcUser.setCreateTime(new Date());
        xcUser.setStatus("1");
        xcUserRepository.save(xcUser);
    }
}
