package com.wangxcit.manage_cms.service;

import com.wangxcit.framework.domain.system.SysDictionary;
import com.wangxcit.manage_cms.dao.SysDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysDictionaryService {
    @Autowired
    SysDictionaryRepository sysDictionaryRepository;
    //根据字典类型查找
    public  SysDictionary findDictionaryByType(String type){
        return sysDictionaryRepository.findByDType(type);
    }
}
