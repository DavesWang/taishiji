package com.wangxcit.framework.domain.media.request;

import com.wangxcit.framework.model.request.RequestData;
import lombok.Data;

@Data
public class QueryMediaFileRequest extends RequestData {

    private String fileOriginalName;
    private String processStatus;
    private String tag;
    //加上用户id 只查询自己的
    private String uid;
}
