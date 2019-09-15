package com.wangxcit.manage_course.controller;

import com.wangxcit.api.course.CourseControllerApi;
import com.wangxcit.framework.domain.course.*;
import com.wangxcit.framework.domain.course.ext.CourseView;
import com.wangxcit.framework.domain.course.ext.TeachplanNode;
import com.wangxcit.framework.domain.course.request.CourseListRequest;
import com.wangxcit.framework.domain.course.response.AddCourseResult;
import com.wangxcit.framework.domain.course.response.CoursePublishResult;
import com.wangxcit.framework.model.response.CommonCode;
import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.framework.utils.XcOauth2Util;
import com.wangxcit.framework.web.BaseController;
import com.wangxcit.manage_course.service.CourseMarketService;
import com.wangxcit.manage_course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController implements CourseControllerApi {
    @Autowired
    CourseService courseService;
    @Autowired
    CourseMarketService courseMarketService;

    //查询课程计划
    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(@PathVariable("courseId") String courseId) {
        return courseService.findTeachplanList(courseId);
    }
    //添加课程计划
    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplan(@RequestBody Teachplan teachplan) {
        return courseService.addTeachplan(teachplan);
    }

    @Override
    @GetMapping("/teachplan/del/{teachplanId}")
    public ResponseResult delTeachplan(@PathVariable("teachplanId") String teachPlanId) {
        return courseService.delTeachplan(teachPlanId);
    }

    //查询课程列表
    @PreAuthorize("hasAuthority('course_find_list')")
    @Override
    @GetMapping("/coursebase/list/{page}/{size}")
    public QueryResponseResult findCourseList(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            CourseListRequest courseListRequest) {
        //使用工具类解析jwt中的用户id
        XcOauth2Util xcOauth2Util = new XcOauth2Util();
        //此Controller继承了 BaseController 来获取request
        XcOauth2Util.UserJwt userJwt = xcOauth2Util.getUserJwtFromHeader(request);
        /*//先试用静态数据  只用用户id
        String company_id = "1";*/
        String userId = userJwt.getId();
        return courseService.findCourseList(userId,page,size,courseListRequest);
    }
    //添加课程
    @PostMapping("/coursebase/add")
    @Override
    public AddCourseResult addCourseBase(@RequestBody CourseBase courseBase) {
        return courseService.addCourseBase(courseBase);
    }
    //得到课程基本信息
    @PreAuthorize("hasAuthority('xc_teachmanager_course_base')")
    @Override
    @GetMapping("/coursebase/get/{courseId}")
    public CourseBase getCourseBaseById(@PathVariable("courseId") String courseId) throws RuntimeException {
        return courseService.getCoursebaseById(courseId);
    }
    //更新课程基本信息
    @Override
    @PutMapping("/coursebase/update/{id}")
    public ResponseResult updateCourseBase(@PathVariable("id") String id, @RequestBody CourseBase courseBase) {
        return courseService.updateCoursebase(id,courseBase);
    }
    //查找课程营销信息
    @Override
    @GetMapping("/coursemarket/get/{courseId}")
    public CourseMarket getCourseMarketById(@PathVariable("courseId") String courseId) {
        return courseMarketService.findCourseMarketById(courseId);
    }
    //更新课程营销信息
    @Override
    @PostMapping("/coursemarket/update/{id}")
    public ResponseResult updateCourseMarket(@PathVariable("id") String id, @RequestBody CourseMarket courseMarket) {
        CourseMarket courseMarket1 = courseMarketService.updateCourseMarket(id, courseMarket);
        System.out.println(courseMarket1);
        if(courseMarket1!=null){
            return new ResponseResult(CommonCode.SUCCESS);
        }else{
            return new ResponseResult(CommonCode.FAIL);
        }
    }

    @Override
    @PostMapping("/coursepic/add")
    public ResponseResult addCoursePic(@RequestParam("courseId") String courseId, @RequestParam("pic") String pic) {
        //保存课程图片
        return courseService.saveCoursePic(courseId,pic);
    }
    //得到课程图片
    @PreAuthorize("hasAuthority('course_find_list')")
    @Override
    @GetMapping("/coursepic/list/{courseId}")
    public CoursePic findCoursePic(@PathVariable("courseId") String courseId) {
        return courseService.findCoursepic(courseId);
    }

    @Override
    @DeleteMapping("/coursepic/delete")
    public ResponseResult deleteCoursePic(@RequestParam("courseId") String courseId) {
        return courseService.deleteCoursePic(courseId);
    }
    //课程模板需要的数据
    @Override
    @GetMapping("/courseview/{id}")
    public CourseView courseview(@PathVariable("id") String id) {
        return courseService.getCourseView(id);
    }
    //  根据课程id 进行课程预览
    @Override
    @PostMapping("/preview/{id}")
    public CoursePublishResult preview(@PathVariable("id") String id) {
        return courseService.preview(id);
    }


    //课程发布
    @Override
    @PostMapping("/publish/{id}")
    public CoursePublishResult publish(@PathVariable("id") String id) {
        return courseService.publish(id);
    }

    @Override
    @PostMapping("/savemedia")
    public ResponseResult savemedia(@RequestBody TeachplanMedia teachplanMedia) {
        return courseService.savemedia(teachplanMedia);
    }
    //获取我的课程
    @PostMapping("/getMyCourse/{page}/{size}")
    @Override
    public QueryResponseResult getMyCourse(@PathVariable("page") int page,@PathVariable("size") int size, @RequestBody String[] courseId) {
        return courseService.getMyCourse(page, size, courseId);
    }


}