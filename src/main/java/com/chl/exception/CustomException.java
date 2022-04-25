package com.chl.exception;

import com.chl.common.ResultCode;

/**
 * @description: 自定义异常
 * @author: mqxu
 **/
public class CustomException extends RuntimeException {
    protected ResultCode resultCode;

    public CustomException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
