package cn.controller;

import cn.pojo.CourseResource;
import cn.service.impl.TestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ws")
public class CourseResourceController {
    @Autowired
    private TestImpl test;
    @RequestMapping("/come")
    /*@ResponseBody*/
    public void getOne(String params) {//@RequestBody CourseResource courseResource
        /*CourseResource courseResource1 = new CourseResource();
        courseResource1.setCourseinfoid(1);
        courseResource1.setCoverpath("1");
        courseResource1.setCredit(2);

        String jsonstr = JSON.toJSONString(courseResource1);
        System.out.println(jsonstr);*/
        System.out.println(params);
        /*JSONObject jsonObject = JSONObject.parseObject(params);
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.toString());*/
    }
    @RequestMapping("/haha")
    public String newPage() {
        return "a";
    }


}
