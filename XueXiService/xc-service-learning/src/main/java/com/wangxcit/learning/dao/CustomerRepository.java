package com.wangxcit.learning.dao;

import com.wangxcit.framework.domain.ucenter.XcUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<XcUser,String> {
}
