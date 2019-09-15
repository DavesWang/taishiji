package com.wangxcit.api.course;

import com.wangxcit.framework.domain.course.*;
import com.wangxcit.framework.domain.course.ext.CourseInfo;
import com.wangxcit.framework.domain.course.ext.CourseView;
import com.wangxcit.framework.domain.course.ext.TeachplanNode;
import com.wangxcit.framework.domain.course.request.CourseListRequest;
import com.wangxcit.framework.domain.course.response.AddCourseResult;
import com.wangxcit.framework.domain.course.response.CoursePublishResult;
import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.framework.model.response.ResponseResult;
import io.swagger.annotations.ApiOperation;

public interface CourseControllerApi {
    @ApiOperation("课程计划查询")
    public TeachplanNode findTeachplanList(String courseId);
    @ApiOperation("添加课程计划")
    public ResponseResult addTeachplan(Teachplan teachplan);
    @ApiOperation("删除课程计划")
    public ResponseResult delTeachplan(String teachPlanId);
    //查询课程列表
    @ApiOperation("查询我的课程列表")
    public QueryResponseResult<CourseInfo> findCourseList(
            int page,
            int size,
            CourseListRequest courseListRequest
    );
    @ApiOperation("添加课程基础信息")
    public AddCourseResult addCourseBase(CourseBase courseBase);
    @ApiOperation("获取课程基础信息")
    public CourseBase getCourseBaseById(String courseId) throws RuntimeException;
    @ApiOperation("更新课程基础信息")
    public ResponseResult updateCourseBase(String id,CourseBase courseBase);
    @ApiOperation("获取课程营销信息")
    public CourseMarket getCourseMarketById(String courseId);
    @ApiOperation("更新课程营销信息")
    public ResponseResult updateCourseMarket(String id,CourseMarket courseMarket);
    @ApiOperation("添加课程图片")
    public ResponseResult addCoursePic(String courseId,String pic);
    @ApiOperation("获取课程图片信息")
    public CoursePic findCoursePic(String courseId);
    @ApiOperation("删除课程图片")
    public ResponseResult deleteCoursePic(String courseId);
    @ApiOperation("课程视图查询接口--模型数据")
    public CourseView courseview(String id);
    @ApiOperation("预览课程")
    public CoursePublishResult preview(String id);
    @ApiOperation("发布课程")
    public CoursePublishResult publish(String id);
    @ApiOperation("保存媒资信息")
    public ResponseResult savemedia(TeachplanMedia teachplanMedia);
    @ApiOperation("获取我的课程")
    public QueryResponseResult getMyCourse(int page,int size,String[] courseId);

}