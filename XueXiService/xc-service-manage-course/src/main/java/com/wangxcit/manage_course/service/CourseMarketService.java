package com.wangxcit.manage_course.service;

import com.wangxcit.framework.domain.course.CourseMarket;
import com.wangxcit.manage_course.dao.CourseMarketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class CourseMarketService {
    //直接在courseController调用了这个service 不写单独controller了
    @Autowired
    CourseMarketRepository courseMarketRepository;
    //得到课程营销信息
    public CourseMarket findCourseMarketById(String courseId){
        Optional<CourseMarket> byId = courseMarketRepository.findById(courseId);
        if(byId.isPresent()){
            return  byId.get();
        }
        return  null;
    }
    //修改课程营销信息
    @Transactional
    public CourseMarket updateCourseMarket(String id, CourseMarket courseMarket) {
        CourseMarket one = this.findCourseMarketById(id);
        if(one!=null){
            one.setCharge(courseMarket.getCharge());
            one.setStartTime(courseMarket.getStartTime());//课程有效期，开始时间
            one.setEndTime(courseMarket.getEndTime());//课程有效期，结束时间
            one.setPrice(courseMarket.getPrice());
            one.setQq(courseMarket.getQq());
            one.setValid(courseMarket.getValid());
            courseMarketRepository.save(one);
        }else{
            //添加课程营销信息
            one = new CourseMarket();
            BeanUtils.copyProperties(courseMarket, one);
            //设置课程id
            one.setId(id);
            courseMarketRepository.save(one);
        }
        return one;
    }
}
