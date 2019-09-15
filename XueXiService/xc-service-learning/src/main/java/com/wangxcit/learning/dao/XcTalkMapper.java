package com.wangxcit.learning.dao;

import com.github.pagehelper.Page;
import com.wangxcit.framework.domain.order.XcTalk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XcTalkMapper {
    /*查询反馈列表*/
    public Page<XcTalk> findByCourseId(String courseid);
}
