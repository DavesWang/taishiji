package com.wangxcit.manage_cms.controller;

import com.wangxcit.api.course.SysDicthinaryControllerApi;
import com.wangxcit.framework.domain.system.SysDictionary;
import com.wangxcit.manage_cms.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/dictionary")
public class SysDictionaryController implements SysDicthinaryControllerApi {
    @Autowired
    SysDictionaryService sysDictionaryService;
    @Override
    @GetMapping("/get/{type}")
    public SysDictionary getByType(@PathVariable("type") String type) {
        return sysDictionaryService.findDictionaryByType(type);
    }
}
