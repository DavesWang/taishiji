package com.wangxcit.auth.controller;

import com.wangxcit.api.auth.AuthControllerApi;
import com.wangxcit.auth.service.AuthService;
import com.wangxcit.framework.domain.ucenter.XcUser;
import com.wangxcit.framework.domain.ucenter.ext.AuthToken;
import com.wangxcit.framework.domain.ucenter.request.LoginRequest;
import com.wangxcit.framework.domain.ucenter.response.AuthCode;
import com.wangxcit.framework.domain.ucenter.response.JwtResult;
import com.wangxcit.framework.domain.ucenter.response.LoginResult;
import com.wangxcit.framework.exception.ExceptionCast;
import com.wangxcit.framework.model.response.CommonCode;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.framework.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AuthController implements AuthControllerApi {

    @Value("${auth.clientId}")
    String clientId;
    @Value("${auth.clientSecret}")
    String clientSecret;
    @Value("${auth.cookieDomain}")
    String cookieDomain;
    @Value("${auth.cookieMaxAge}")
    int cookieMaxAge;

    @Autowired
    AuthService authService;
    //登录
    @Override
    @PostMapping("/userlogin")
    public LoginResult login(LoginRequest loginRequest) {
        if(loginRequest == null || StringUtils.isEmpty(loginRequest.getUsername())){
            ExceptionCast.cast(AuthCode.AUTH_USERNAME_NONE);
        }
        if(loginRequest == null || StringUtils.isEmpty(loginRequest.getPassword())){
            ExceptionCast.cast(AuthCode.AUTH_PASSWORD_NONE);
        }
        //账号
        String username = loginRequest.getUsername();
        //密码
        String password = loginRequest.getPassword();

        //申请令牌
        AuthToken authToken =  authService.login(username,password,clientId,clientSecret);

        //用户身份令牌
        String access_token = authToken.getAccess_token();
        //将令牌存储到cookie
        this.saveCookie(access_token);

        return new LoginResult(CommonCode.SUCCESS,access_token);
    }

    //登出
    @Override
    @PostMapping("/userlogout")
    public ResponseResult logout()
    {
        //拿到cookie中的uid
        String uid = getTokenFormCookie();
        //删除redis中的token
        authService.delToken(uid);
       /* if(!b){
            ExceptionCast.cast(AuthCode.AUTH_LOGOUT_FAIL);
        }*/
        //清除cookie
        this.clearCookie(uid);
        return new ResponseResult(CommonCode.SUCCESS);
    }
    //将jwt返回给用户
    @Override
    @GetMapping("/userjwt")
    public JwtResult userjwt() {
        //取出cookie中的用户身份令牌
        String uid = getTokenFormCookie();
        if(uid==null){
            return new JwtResult(CommonCode.FAIL,null);
        }
        //拿身份令牌从redis中查询jwt令牌
        AuthToken userToken = authService.getUserToken(uid);
        if(userToken!=null){
            //将jwt令牌返回给用户
            String jwt_token = userToken.getJwt_token();
            return new JwtResult(CommonCode.SUCCESS,jwt_token);
        }
        return null;
    }
    //注册
    @Override
    @PostMapping("/register")
    public ResponseResult register(@RequestBody XcUser xcUser) {
        ResponseResult result = authService.register(xcUser);
        return result;
    }

    @Override
    @GetMapping("/getuserinfo/{userId}")
    public XcUser getUserInfo(@PathVariable String userId) {
        return authService.getUserInfo(userId);
    }

    @Override
    @PostMapping("/setting")
    public ResponseResult setting(@RequestBody XcUser xcUser) {
        return authService.setting(xcUser);
    }

    //将令牌存储到cookie
    private void saveCookie(String token){

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //HttpServletResponse response,String domain,String path, String name, String value, int maxAge,boolean httpOnly
        CookieUtil.addCookie(response,cookieDomain,"/","uid",token,cookieMaxAge,false);

    }
    //从cookie删除token
    private void clearCookie(String token){

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //HttpServletResponse response,String domain,String path, String name, String value, int maxAge,boolean httpOnly
        CookieUtil.addCookie(response,cookieDomain,"/","uid",token,0,false);
    }
    //取出cookie中的身份令牌
    private String getTokenFormCookie(){
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String,String> map = CookieUtil.readCookie(httpServletRequest,"uid");
        if(map!=null && map.get("uid")!=null){
            String uid = map.get("uid");
            return uid;
        }
        return null;
    }
}
