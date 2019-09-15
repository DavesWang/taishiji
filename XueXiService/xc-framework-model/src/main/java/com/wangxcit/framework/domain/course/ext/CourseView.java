package com.wangxcit.framework.domain.course.ext;

import com.wangxcit.framework.domain.course.CourseBase;
import com.wangxcit.framework.domain.course.CourseMarket;
import com.wangxcit.framework.domain.course.CoursePic;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CourseView implements java.io.Serializable {
    CourseBase courseBase;//基础信息
    CourseMarket courseMarket;//课程营销信息
    CoursePic coursePic;//课程图片
    TeachplanNode teachplanNode;//教学计划
}
