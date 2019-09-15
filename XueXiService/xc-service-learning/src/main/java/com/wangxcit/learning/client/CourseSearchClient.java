package com.wangxcit.learning.client;

import com.wangxcit.framework.client.XcServiceList;
import com.wangxcit.framework.domain.course.TeachplanMediaPub;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value= XcServiceList.XC_SERVICE_SEARCH)
public interface CourseSearchClient{

    //根据课程计划id查询课程媒资
    @GetMapping("/search/course/getmedia/{teachplanId}")
    public TeachplanMediaPub getmedia(@PathVariable("teachplanId") String teachplanId);
}
