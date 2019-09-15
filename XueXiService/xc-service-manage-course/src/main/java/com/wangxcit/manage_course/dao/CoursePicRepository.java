package com.wangxcit.manage_course.dao;

import com.wangxcit.framework.domain.course.CoursePic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursePicRepository extends JpaRepository<CoursePic,String> {
    long deleteByCourseid(String courseid);

}
