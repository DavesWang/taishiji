package com.wangxcit.manage_cms.dao;

import com.wangxcit.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {

}
