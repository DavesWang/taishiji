package com.wangxcit.api.auth;

import com.wangxcit.framework.domain.ucenter.XcUser;
import com.wangxcit.framework.domain.ucenter.request.LoginRequest;
import com.wangxcit.framework.domain.ucenter.response.JwtResult;
import com.wangxcit.framework.domain.ucenter.response.LoginResult;
import com.wangxcit.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "用户认证",description = "用户认证接口")
public interface AuthControllerApi {
    @ApiOperation("登录")
    public LoginResult login(LoginRequest loginRequest);

    @ApiOperation("退出")
    public ResponseResult logout();
    @ApiOperation("查询userjwt令牌")
    public JwtResult userjwt();
    @ApiOperation(("注册"))
    public ResponseResult register(XcUser xcUser);
    @ApiOperation("查询个人信息")
    public XcUser getUserInfo(String userId);
    @ApiOperation("修改个人信息")
    public ResponseResult setting(XcUser xcUser);
}
