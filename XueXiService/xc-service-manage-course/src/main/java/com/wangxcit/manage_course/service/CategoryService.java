package com.wangxcit.manage_course.service;

import com.wangxcit.framework.domain.course.ext.CategoryNode;
import com.wangxcit.manage_course.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    public CategoryNode findList(){
        return categoryMapper.selectList();
    }

}
