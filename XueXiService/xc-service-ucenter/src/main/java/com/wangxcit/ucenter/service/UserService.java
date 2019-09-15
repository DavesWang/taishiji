package com.wangxcit.ucenter.service;

import com.wangxcit.framework.domain.ucenter.XcMenu;
import com.wangxcit.framework.domain.ucenter.XcUser;
import com.wangxcit.framework.domain.ucenter.XcUserRole;
import com.wangxcit.framework.domain.ucenter.ext.XcUserExt;
import com.wangxcit.framework.model.response.CommonCode;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.ucenter.dao.XcMenuMapper;
import com.wangxcit.ucenter.dao.XcUserRepository;
import com.wangxcit.ucenter.dao.XcUserRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    XcUserRepository xcUserRepository;
    @Autowired
    XcMenuMapper xcMenuMapper;
    //操纵用户角色表
    @Autowired
    XcUserRoleRepository xcUserRoleRepository;
    //根据帐号查询xcUser信息
    public XcUser findXcUserByUsername(String username){
        return xcUserRepository.findByUsername(username);
    }
    //根据帐号查询用户信息
    public XcUserExt getUserExt(String userName){
        XcUserExt xcUserExt = new XcUserExt();
        //根据帐号查询xcUser信息
        XcUser xcUser = findXcUserByUsername(userName);
        if(xcUser == null){
            return null;
        }
        //拿到用户id
        String userId = xcUser.getId();
        //查询用户的权限
        List<XcMenu> xcMenus = xcMenuMapper.selectPermissionByUserId(userId);
        xcUserExt.setPermissions(xcMenus);
        BeanUtils.copyProperties(xcUser,xcUserExt);
        return xcUserExt;
    }
    @Transactional
    public ResponseResult register(XcUser xcUser){
        //待实现 根据用户类型添加角色信息
        //添加信息  拿到返回值
        xcUser.setStatus("1");
        xcUser.setCreateTime(new Date());
        xcUser.setPassword(new BCryptPasswordEncoder().encode(xcUser.getPassword()));
        //每个人初始值为1000
        xcUser.setMoney(1000f);
        XcUser save = xcUserRepository.save(xcUser);

        //根据用户类型添加角色信息
        XcUserRole xcUserRole = new XcUserRole();
        xcUserRole.setUserId(save.getId());
        xcUserRole.setCreateTime(new Date());
        if(xcUser.getUtype().equals("101001")){
            //添加学生角色
            xcUserRole.setRoleId("17");
        }else{
            //则为101002
            xcUserRole.setRoleId("20");
        }
        //保存信息
        xcUserRoleRepository.save(xcUserRole);
        return new ResponseResult(CommonCode.SUCCESS);
    }
    //更新个人信息
    public ResponseResult setting(XcUser xcUser){
        XcUser originUser = xcUserRepository.findById(xcUser.getId()).get();
        System.out.println("原来"+originUser);
        //现将密码加密
        originUser.setPassword(new BCryptPasswordEncoder().encode(xcUser.getPassword()));
        originUser.setName(xcUser.getName());
        originUser.setQq(xcUser.getQq());
        originUser.setBirthday(xcUser.getBirthday());
        originUser.setEmail(xcUser.getEmail());
        originUser.setPhone(xcUser.getPhone());
        originUser.setSex(xcUser.getSex());
        originUser.setUpdateTime(new Date());
        System.out.println("更新"+originUser);
        xcUserRepository.save(originUser);
        return new ResponseResult(CommonCode.SUCCESS);
    }
    public XcUser getUserInfo(String userId){
        XcUser xcUser = xcUserRepository.findById(userId).get();
        return xcUser;
    }
}
