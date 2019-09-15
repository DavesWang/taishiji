package com.wangxcit.learning.dao;

import com.github.pagehelper.Page;
import com.wangxcit.framework.domain.order.MyCourse;
import com.wangxcit.framework.domain.order.XcOrders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XcOrderMapper {
    /*查询买家订单*/
    public Page<XcOrders> findListByUid(String uid);
    /*查询卖家订单*/
    public Page<XcOrders> findListByUid1(String uid);

}
