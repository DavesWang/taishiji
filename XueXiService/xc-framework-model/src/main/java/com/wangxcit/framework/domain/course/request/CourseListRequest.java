package com.wangxcit.framework.domain.course.request;

import com.wangxcit.framework.model.request.RequestData;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class CourseListRequest extends RequestData {
    //用户Id
    private String UserId;
}
