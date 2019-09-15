package com.wangxcit.learning.dao;

import com.wangxcit.framework.domain.order.XcOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XcOrdersRepository extends JpaRepository<XcOrders,String> {
    XcOrders findByCourseidAndAndBuyerid(String courseId,String buyerId);
}
