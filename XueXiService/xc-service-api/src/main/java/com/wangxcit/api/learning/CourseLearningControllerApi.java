package com.wangxcit.api.learning;


import com.wangxcit.framework.domain.learning.response.GetMediaResult;
import com.wangxcit.framework.domain.order.XcOrders;
import com.wangxcit.framework.domain.order.XcTalk;
import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "录播课程学习管理",description = "录播课程学习管理")
public interface CourseLearningControllerApi {
    @ApiOperation("获取课程学习地址")
    public GetMediaResult getmedia(String courseId, String teachplanId);
    @ApiOperation("生成订单")
    public ResponseResult addorder(XcOrders xcOrders);
    @ApiOperation("查询购买订单")
    public QueryResponseResult orderlist(int page,int size,String uid);
    @ApiOperation("查询售出订单")
    public QueryResponseResult orderlist1(int page,int size,String uid);
    @ApiOperation("我的课程")
    public QueryResponseResult courseList(int page,int size,String uid);
    @ApiOperation("课程反馈")
    public ResponseResult talk(XcTalk xcTalk);
    @ApiOperation("反馈列表")
    public QueryResponseResult talklist(int page, int size, String courseid);
}
