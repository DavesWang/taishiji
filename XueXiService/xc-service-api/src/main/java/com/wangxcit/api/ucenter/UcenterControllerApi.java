package com.wangxcit.api.ucenter;

import com.wangxcit.framework.domain.ucenter.XcUser;
import com.wangxcit.framework.domain.ucenter.ext.XcUserExt;
import com.wangxcit.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;

@Api(value = "用户中心",description = "用户注册登录")
public interface UcenterControllerApi {
    public XcUserExt getUserext(String username);
    public ResponseResult register(XcUser xcUser);
    public ResponseResult setting(XcUser xcUser);
    public XcUser getUserInfo(String userid);
}
