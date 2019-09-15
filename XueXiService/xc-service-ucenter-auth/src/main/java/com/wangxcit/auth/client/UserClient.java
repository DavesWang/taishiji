package com.wangxcit.auth.client;

import com.wangxcit.framework.client.XcServiceList;
import com.wangxcit.framework.domain.ucenter.XcUser;
import com.wangxcit.framework.domain.ucenter.ext.XcUserExt;
import com.wangxcit.framework.model.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = XcServiceList.XC_SERVICE_UCENTER)
public interface UserClient {
    //根据帐号查询用户信息
    @GetMapping("/ucenter/getuserext")
    public XcUserExt getUserext(@RequestParam("username") String username);
    @PostMapping("/ucenter/register")
    public ResponseResult register(@RequestBody XcUser xcUser);
    @GetMapping("/ucenter/getuserinfo/{userId}")
    public XcUser getUserInfo(@PathVariable(value = "userId") String userId);
    @PostMapping("/ucenter/setting")
    public ResponseResult setting(@RequestBody XcUser xcUser);
}
