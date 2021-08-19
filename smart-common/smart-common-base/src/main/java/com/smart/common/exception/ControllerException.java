package com.smart.common.exception;

import com.smart.common.vo.ResponseCode;
import lombok.Getter;

@Getter
public class ControllerException extends BaseException {
    public ControllerException(ResponseCode responseCode) {
        super(responseCode);
    }
}
