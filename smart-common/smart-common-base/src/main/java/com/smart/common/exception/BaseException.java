package com.smart.common.exception;

import com.smart.common.vo.ResponseCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private String msg;
    private int status;
    private ResponseCode responseCode;

    public BaseException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.msg = responseCode.getMsg();
        this.status = responseCode.getStatus();
        this.responseCode = responseCode;
    }
}
