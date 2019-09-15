package com.wangxcit.framework.domain.order;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class MyCourse {
    private String courseId;
    private String courseName;
    private Date endTime;
}
