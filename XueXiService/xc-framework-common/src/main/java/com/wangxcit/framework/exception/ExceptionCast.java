package com.wangxcit.framework.exception;

import com.wangxcit.framework.model.response.ResultCode;


public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
