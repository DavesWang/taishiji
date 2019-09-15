package com.wangxcit.learning.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wangxcit.framework.domain.course.TeachplanMediaPub;

import com.wangxcit.framework.domain.learning.response.GetMediaResult;
import com.wangxcit.framework.domain.learning.response.LearningCode;
import com.wangxcit.framework.domain.order.XcOrders;
import com.wangxcit.framework.domain.order.XcTalk;
import com.wangxcit.framework.domain.ucenter.XcUser;
import com.wangxcit.framework.exception.ExceptionCast;
import com.wangxcit.framework.model.response.CommonCode;
import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.framework.model.response.QueryResult;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.learning.client.CourseSearchClient;
import com.wangxcit.learning.client.MyCourseCilent;
import com.wangxcit.learning.dao.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LearningService {

    @Autowired
    CourseSearchClient courseSearchClient;
    @Autowired
    XcOrdersRepository xcOrdersRepository;
    @Autowired
    XcUserRepository xcUserRepository;
    @Autowired
    XcOrderMapper xcOrderMapper;
    @Autowired
    MyCourseCilent myCourseCilent;
    @Autowired
    XcTalkRepository xcTalkRepository;
    @Autowired
    XcTalkMapper xcTalkMapper;

    //获取课程学习地址（视频播放地址）
    public GetMediaResult getmedia(String courseId, String teachplanId) {
        //校验学生的学生权限...

        //远程调用搜索服务查询课程计划所对应的课程媒资信息
        TeachplanMediaPub teachplanMediaPub = courseSearchClient.getmedia(teachplanId);
        if(teachplanMediaPub == null || StringUtils.isEmpty(teachplanMediaPub.getMediaUrl())){
            //获取学习地址错误
            ExceptionCast.cast(LearningCode.LEARNING_GETMEDIA_ERROR);
        }
        return new GetMediaResult(CommonCode.SUCCESS,teachplanMediaPub.getMediaUrl());
    }
    @Transactional
    public ResponseResult addorder(XcOrders xcOrders) {
        System.out.println(xcOrders);
        //先根据买家和课程查找是否已经购买过 或是商家自己
        XcOrders oldxcOrders = xcOrdersRepository.findByCourseidAndAndBuyerid(xcOrders.getCourseid(), xcOrders.getBuyerid());
        if(oldxcOrders!=null||xcOrders.getBuyerid().equals(xcOrders.getSellerid())){
            return new ResponseResult(CommonCode.SUCCESS);
        }
        //先判断是否免费
        if(xcOrders.getPrice()!=null&&!xcOrders.getPrice().equals("")){
            //找到买家
            if(xcUserRepository.findById(xcOrders.getBuyerid()).isPresent()) {
                XcUser buyer = xcUserRepository.findById(xcOrders.getBuyerid()).get();
                buyer.setMoney(buyer.getMoney() - xcOrders.getPrice());
                xcUserRepository.save(buyer);
            }else{
                return new ResponseResult(CommonCode.FAIL);
            }
            //找到卖家
            if(xcUserRepository.findById(xcOrders.getSellerid()).isPresent()) {
                XcUser seller = xcUserRepository.findById(xcOrders.getSellerid()).get();
                seller.setMoney(seller.getMoney() + xcOrders.getPrice());
                xcUserRepository.save(seller);
            }else{
                return new ResponseResult(CommonCode.FAIL);
            }
        }
        //保存订单
        xcOrders.setStatus("1");
        xcOrders.setOrdertime(new Date());
        if(xcOrders.getPrice()==null||xcOrders.getPrice().equals("")) {
            xcOrders.setPrice(0.0f);
        }
        xcOrdersRepository.save(xcOrders);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public QueryResponseResult getOrderList(int page, int size, String uid) {
        if(page<=0){
            page = 0;
        }
        if(size<=0){
            size = 20;
        }
        //设置分页参数
        PageHelper.startPage(page, size);
        //分页查询
        Page<XcOrders> orderListPage = xcOrderMapper.findListByUid(uid);
        //查询列表
        List<XcOrders> list = orderListPage.getResult();
        //总记录数
        long total = orderListPage.getTotal();
        //查询结果集
        QueryResult<XcOrders> queryResult = new QueryResult<XcOrders>();
        queryResult.setList(list);
        queryResult.setTotal(total);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    public QueryResponseResult getCourseList(int page, int size, String uid) {
        QueryResponseResult orderList = this.getOrderList(1, 1000, uid);
        //因为不在一个库，设计问题，使用发送远程请求获取我的课程
        List<XcOrders> list = orderList.getQueryResult().getList();
        //得到课程id列表
        List<String> couseIdList = new ArrayList<String>();
        for(XcOrders xcOrders : list){
            couseIdList.add(xcOrders.getCourseid());
        }
        //得到订单里面所有的课程id
        String[] ids = couseIdList.toArray(new String[couseIdList.size()]);
        //发送远程请求 得到结果
        return  myCourseCilent.getMyCourse(page, size, ids);
    }
    /*查询售出订单*/
    public QueryResponseResult getOrderList1(int page, int size, String uid) {
        if(page<=0){
            page = 0;
        }
        if(size<=0){
            size = 20;
        }
        //设置分页参数
        PageHelper.startPage(page, size);
        //分页查询
        Page<XcOrders> orderListPage = xcOrderMapper.findListByUid1(uid);
        //查询列表
        List<XcOrders> list = orderListPage.getResult();
        //总记录数
        long total = orderListPage.getTotal();
        //查询结果集
        QueryResult<XcOrders> queryResult = new QueryResult<XcOrders>();
        queryResult.setList(list);
        queryResult.setTotal(total);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }
        /*提交反馈*/
    public ResponseResult saveTalk(XcTalk xcTalk) {
        xcTalk.setTalktime(new Date());
        System.out.println(xcTalk);
        XcTalk save = xcTalkRepository.save(xcTalk);
        if(save.getId()!=null){
            return  new ResponseResult(CommonCode.SUCCESS);
        }else{
            return  new ResponseResult(CommonCode.FAIL);
        }
    }

    public QueryResponseResult gettalklist(int page, int size, String courseid) {
        if(page<=0){
            page = 0;
        }
        if(size<=0){
            size = 20;
        }
        //设置分页参数
        PageHelper.startPage(page, size);
        //分页查询
        Page<XcTalk> talkListPage = xcTalkMapper.findByCourseId(courseid);
        //查询列表
        List<XcTalk> list = talkListPage.getResult();
        System.out.println(list);
        //总记录数
        long total = talkListPage.getTotal();
        //查询结果集
        QueryResult<XcTalk> queryResult = new QueryResult<XcTalk>();
        queryResult.setList(list);
        queryResult.setTotal(total);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }
}
