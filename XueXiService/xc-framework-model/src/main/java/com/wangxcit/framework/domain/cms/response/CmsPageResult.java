package com.wangxcit.framework.domain.cms.response;

import com.wangxcit.framework.domain.cms.CmsPage;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CmsPageResult extends ResponseResult {
    CmsPage cmsPage;
    public CmsPageResult(ResultCode resultCode,CmsPage cmsPage) {
        super(resultCode);
        this.cmsPage = cmsPage;
    }
}
