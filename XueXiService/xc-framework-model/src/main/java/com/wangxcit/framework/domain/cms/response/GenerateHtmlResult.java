package com.wangxcit.framework.domain.cms.response;

import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.framework.model.response.ResultCode;
import lombok.Data;


@Data
public class GenerateHtmlResult extends ResponseResult {
    String html;
    public GenerateHtmlResult(ResultCode resultCode, String html) {
        super(resultCode);
        this.html = html;
    }
}
