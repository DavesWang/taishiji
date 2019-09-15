package com.wangxcit.manage_cms.dao;

import com.wangxcit.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysDictionaryRepository extends MongoRepository<SysDictionary,String> {
    //根据字典分类查询字典信息
    SysDictionary findByDType(String dType);
}
