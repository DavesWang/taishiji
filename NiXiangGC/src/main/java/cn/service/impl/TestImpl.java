package cn.service.impl;

import cn.daoInterface.CourseResourceMapper;
import cn.pojo.CourseInfo;
import cn.pojo.CourseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestImpl {
    @Autowired
    CourseResourceMapper courseResourceMapper;
    public CourseResource doSometing(int id) {
        CourseResource courseResource = courseResourceMapper.selectByPrimaryKey(id);
        return courseResource;
    }
}
