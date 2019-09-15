package com.wangxcit.manage_course.dao;

import com.wangxcit.framework.domain.cms.CmsPage;
import com.wangxcit.manage_course.client.CmsPageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFeign {
    @Autowired
    CmsPageClient cmsPageClient;
    @Test
    public void testAA(){
        CmsPage byId = cmsPageClient.findById("5a795ac7dd573c04508f3a56");
        System.out.println(byId);

    }
}
