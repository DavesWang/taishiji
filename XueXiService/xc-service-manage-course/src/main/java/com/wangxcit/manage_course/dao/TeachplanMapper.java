package com.wangxcit.manage_course.dao;

import com.wangxcit.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeachplanMapper {
    public abstract TeachplanNode selectList(String courseId);
    public  abstract void delTeachplan(String teachplanId);
}
