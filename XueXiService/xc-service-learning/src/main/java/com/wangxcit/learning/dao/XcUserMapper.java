package com.wangxcit.learning.dao;

import com.github.pagehelper.Page;
import com.wangxcit.framework.domain.ucenter.XcUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XcUserMapper {
    public Page<XcUser> findAll();
}

