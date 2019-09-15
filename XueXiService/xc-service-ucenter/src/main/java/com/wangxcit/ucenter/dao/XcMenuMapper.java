package com.wangxcit.ucenter.dao;

import com.wangxcit.framework.domain.ucenter.XcMenu;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface XcMenuMapper {
    //根据用户id查询用户的权限
    public List<XcMenu> selectPermissionByUserId(String userid);
}
