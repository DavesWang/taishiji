package com.wangxcit.ucenter.dao;

import com.wangxcit.framework.domain.ucenter.XcUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XcUserRepository extends JpaRepository<XcUser,String> {
    //根据帐号查询用户信息
    XcUser findByUsername(String username);
}
