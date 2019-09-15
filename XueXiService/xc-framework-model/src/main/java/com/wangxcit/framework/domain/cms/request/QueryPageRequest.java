package com.wangxcit.framework.domain.cms.request;

import com.wangxcit.framework.model.request.RequestData;
import lombok.Data;

@Data
public class QueryPageRequest extends RequestData {
    //站点id
    private String siteId;
    //页面id
    private String pageId;
    //页面名称
    private String pageName;
    //页面别名
    private String pageAliase;
    //模板Id
    private String templateId;
}
