package com.wangxcit.learning.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wangxcit.framework.domain.ucenter.XcUser;
import com.wangxcit.framework.model.response.CommonCode;
import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.framework.model.response.QueryResult;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.learning.dao.CustomerRepository;
import com.wangxcit.learning.dao.XcUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    XcUserMapper xcUserMapper;

    public QueryResponseResult findList(int page, int size) {
        if(page<=0){
            page = 0;
        }
        if(size<=0){
            size = 20;
        }
        //设置分页参数
        PageHelper.startPage(page, size);
        //分页查询
        Page<XcUser> userListPage = xcUserMapper.findAll();
        //查询列表
        List<XcUser> list = userListPage.getResult();
        //总记录数
        long total = userListPage.getTotal();
        //查询结果集
        QueryResult<XcUser> queryResult = new QueryResult<XcUser>();
        queryResult.setList(list);
        queryResult.setTotal(total);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    public ResponseResult closeUser(String id) {
        Optional<XcUser> byId = customerRepository.findById(id);
        if(byId.isPresent()){
            XcUser xcUser = byId.get();
            /*封禁*/
            xcUser.setStatus("2");
            /*更新*/
            customerRepository.save(xcUser);
            return new ResponseResult(CommonCode.SUCCESS);
        }else{
            return new ResponseResult(CommonCode.SUCCESS);
        }
    }

    public ResponseResult openUser(String id) {
        Optional<XcUser> byId = customerRepository.findById(id);
        if(byId.isPresent()){
            XcUser xcUser = byId.get();
            /*解封*/
            xcUser.setStatus("1");
            /*更新*/
            customerRepository.save(xcUser);
            return new ResponseResult(CommonCode.SUCCESS);
        }else{
            return new ResponseResult(CommonCode.SUCCESS);
        }
    }
}
