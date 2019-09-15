package com.wangxcit.api.cms;

import com.wangxcit.framework.domain.cms.CmsPage;
import com.wangxcit.framework.domain.cms.request.QueryPageRequest;
import com.wangxcit.framework.domain.cms.response.CmsPageResult;
import com.wangxcit.framework.domain.cms.response.CmsPostPageResult;
import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.framework.model.response.ResponseResult;
import io.swagger.annotations.ApiOperation;


//Swagger测试
public interface CmsPageControllerApi {

    //页面查询
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
    //页面添加
    public CmsPageResult add(CmsPage cmsPage);
    //查找一个
    public CmsPage findById( String id);
    //修改
    public ResponseResult delete(String id);
    @ApiOperation("发布页面")
    public ResponseResult post(String pageId);
    @ApiOperation("保存页面 没有则添加 有了则更新")
    public CmsPageResult save(CmsPage cmsPage);
    @ApiOperation("一键发布页面")
    public CmsPostPageResult postPageQuick(CmsPage cmsPage);
}
