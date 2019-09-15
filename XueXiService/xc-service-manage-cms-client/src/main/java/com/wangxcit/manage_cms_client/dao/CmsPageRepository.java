package com.wangxcit.manage_cms_client.dao;

import com.wangxcit.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsPageRepository extends MongoRepository<CmsPage,String>{
}
