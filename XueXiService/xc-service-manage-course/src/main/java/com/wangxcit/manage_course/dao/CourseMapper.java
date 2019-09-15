package com.wangxcit.manage_course.dao;

import com.github.pagehelper.Page;
import com.wangxcit.framework.domain.course.CourseBase;
import com.wangxcit.framework.domain.course.ext.CourseInfo;
import com.wangxcit.framework.domain.course.request.CourseListRequest;
import com.wangxcit.framework.domain.order.MyCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CourseMapper {
   CourseBase findCourseBaseById(String id);
   Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);
   Page<MyCourse> findMyCourse(@Param("courseIds") String[] courseIds);
}
