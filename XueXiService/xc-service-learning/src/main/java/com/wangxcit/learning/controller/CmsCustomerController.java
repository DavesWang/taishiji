package com.wangxcit.learning.controller;

import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.learning.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learning/customer")
public class CmsCustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int
            size) {
        return customerService.findList(page,size);
    }
    /*封禁*/
    @PostMapping("/close/{userId}")
    public ResponseResult closeUser(@PathVariable("userId") String id){
        return customerService.closeUser(id);
    }
    @PostMapping("/open/{userId}")
    public ResponseResult openUser(@PathVariable("userId") String id){
        return customerService.openUser(id);
    }
}
