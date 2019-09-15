package com.wangxcit.framework.domain.cms.response;

import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //无参构造，使用feign 返回复杂类型必须有无参构造
public class CmsPostPageResult extends ResponseResult{
    String pageUrl;
    public CmsPostPageResult(ResultCode resultCode, String pageUrl) {
        super(resultCode);
        this.pageUrl = pageUrl;
    }
}
