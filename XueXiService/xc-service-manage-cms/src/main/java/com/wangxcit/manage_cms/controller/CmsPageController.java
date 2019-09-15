package com.wangxcit.manage_cms.controller;

import com.wangxcit.api.cms.CmsPageControllerApi;
import com.wangxcit.framework.domain.cms.CmsPage;
import com.wangxcit.framework.domain.cms.request.QueryPageRequest;
import com.wangxcit.framework.domain.cms.response.CmsPageResult;
import com.wangxcit.framework.domain.cms.response.CmsPostPageResult;
import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //相当于Controller和responseBody
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {
    @Autowired
    PageService pageService;
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int
            size, QueryPageRequest queryPageRequest) {
/*//暂时采用测试数据，测试接口是否可以正常运行
        QueryResult queryResult = new QueryResult();
        queryResult.setTotal(2);
//静态数据列表
        List list = new ArrayList();
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("测试页面");
        list.add(cmsPage);
        queryResult.setList(list);
        QueryResponseResult queryResponseResult = new
                QueryResponseResult(CommonCode.SUCCESS,queryResult);*/
        System.out.println(111111111);
        return pageService.findList(page,size,queryPageRequest);
    }
    @PostMapping("/add")
    @Override
    public CmsPageResult add(@RequestBody CmsPage cmsPage) {
        return  pageService.add(cmsPage);
    }
    @GetMapping("/get/{id}")
    public CmsPage findById(@PathVariable String id){
        return pageService.findById(id);
    }
    @PutMapping("/edit/{id}") //此处使用put 符合http规范的更新请求
    public CmsPageResult edit(@PathVariable String id,@RequestBody CmsPage cmsPage){
        return pageService.updatePage(id,cmsPage);
    }
    @DeleteMapping("/del/{id}") //使用http的delete方法完成岗位操作
    public ResponseResult delete(@PathVariable("id") String id) {
        return pageService.delete(id);
    }

    @Override
    @PostMapping("/postPage/{pageId}")
    public ResponseResult post(@PathVariable("pageId") String pageId) {
        return pageService.postPage(pageId);
    }
    //保存或者更新
    @Override
    @PostMapping("/save")
    public CmsPageResult save(@RequestBody CmsPage cmsPage) {
        return pageService.save(cmsPage);
    }
    //一键发布
    @Override
    @PostMapping("/postPageQuick")
    public CmsPostPageResult postPageQuick(@RequestBody CmsPage cmsPage) {
        return pageService.postPageQuick(cmsPage);
    }

}
