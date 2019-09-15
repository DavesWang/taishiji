package com.wangxcit.manage_cms.dao;

import com.wangxcit.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CmsPageRepository extends MongoRepository<CmsPage,String>{
    /**
     * //站点ID
     private String siteId;
     //页面ID
     @Id
     private String pageId;
     //页面名称
     private String pageName;
     //别名
     private String pageAliase;
     */
    public abstract List<CmsPage> findByPageName(String name);
    //根据页面名称 站点ID 页面路径 查询
    public abstract CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName,String SiteId,String PageWebPath);
}
