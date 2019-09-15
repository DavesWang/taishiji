package com.wangxcit.manage_course.dao;

import com.wangxcit.framework.domain.course.CourseBase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseBaseRepository extends JpaRepository<CourseBase,String> {
}
