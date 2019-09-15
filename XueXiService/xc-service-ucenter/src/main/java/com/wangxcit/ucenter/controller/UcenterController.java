package com.wangxcit.ucenter.controller;

import com.wangxcit.api.ucenter.UcenterControllerApi;
import com.wangxcit.framework.domain.ucenter.XcUser;
import com.wangxcit.framework.domain.ucenter.ext.XcUserExt;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ucenter")
public class UcenterController implements UcenterControllerApi {
    @Autowired
    UserService userService;
    @Override
    @GetMapping("/getuserext")
    public XcUserExt getUserext(String username) {
      return  userService.getUserExt(username);
    }

    @Override
    @PostMapping("/register")
    public ResponseResult register(@RequestBody XcUser xcUser) {
        return userService.register(xcUser);
    }

    @Override
    @PostMapping("/setting")
    public ResponseResult setting(@RequestBody XcUser xcUser) {
        return userService.setting(xcUser);
    }

    @Override
    @GetMapping("/getuserinfo/{userId}")
    public XcUser getUserInfo(@PathVariable(value = "userId") String userId) {
        return userService.getUserInfo(userId);
    }

}
