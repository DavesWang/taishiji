package com.wangxcit.learning.client;

import com.wangxcit.framework.client.XcServiceList;
import com.wangxcit.framework.model.response.QueryResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value= XcServiceList.XC_SERVICE_MANAGE_COURSE)
public interface MyCourseCilent {
    @PostMapping("/course/getMyCourse/{page}/{size}")
    public QueryResponseResult getMyCourse(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody String[] courseId);
}
