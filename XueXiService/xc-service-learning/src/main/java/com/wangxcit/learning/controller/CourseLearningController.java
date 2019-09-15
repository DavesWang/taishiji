package com.wangxcit.learning.controller;

import com.wangxcit.api.learning.CourseLearningControllerApi;

import com.wangxcit.framework.domain.learning.response.GetMediaResult;
import com.wangxcit.framework.domain.order.XcOrders;
import com.wangxcit.framework.domain.order.XcTalk;
import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.learning.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learning/course")
public class CourseLearningController implements CourseLearningControllerApi {

    @Autowired
    LearningService learningService;

    @Override
    @GetMapping("/getmedia/{courseId}/{teachplanId}")
    public GetMediaResult getmedia(@PathVariable("courseId") String courseId,
                                   @PathVariable("teachplanId")String teachplanId) {

        return learningService.getmedia(courseId,teachplanId);
    }

    @Override
    @PostMapping ("/addorder")
    public ResponseResult addorder(@RequestBody XcOrders xcOrders) {
        return learningService.addorder(xcOrders);
    }

    @Override
    @GetMapping("/order/list/{page}/{size}/{uid}")
    public QueryResponseResult orderlist(@PathVariable("page") int page,@PathVariable("size") int size,@PathVariable("uid") String uid) {
        return learningService.getOrderList(page,size,uid);
    }
    /*卖家方查询订单，售出订单*/
    @Override
    @GetMapping("/order/list1/{page}/{size}/{uid}")
    public QueryResponseResult orderlist1(@PathVariable("page") int page,@PathVariable("size") int size,@PathVariable("uid") String uid) {
        return learningService.getOrderList1(page,size,uid);
    }
    /*查询我的课程*/
    @Override
    @GetMapping("/course/list/{page}/{size}/{uid}")
    public QueryResponseResult courseList(@PathVariable("page")int page, @PathVariable("size") int size,@PathVariable("uid") String uid) {
        return learningService.getCourseList(page,size,uid);
    }
    /*发布反馈*/
    @Override
    @PostMapping("/talk")
    public ResponseResult talk(@RequestBody XcTalk xcTalk) {
        return learningService.saveTalk(xcTalk);
    }
    /*反馈列表*/
    @Override
    @GetMapping("/talk/list/{page}/{size}/{courseid}")
    public QueryResponseResult talklist(@PathVariable("page") int page,@PathVariable("size") int size,@PathVariable("courseid") String courseid) {
        return learningService.gettalklist(page,size,courseid);
    }
}
