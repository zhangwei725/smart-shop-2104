package com.smart.common.exception;

import com.smart.common.vo.ResponseCode;
import lombok.Getter;

@Getter
public class ServiceException extends BaseException {
    public ServiceException(ResponseCode responseCode) {
        super(responseCode);
    }
}
