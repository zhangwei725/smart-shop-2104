package com.smart.common.exception;

import com.smart.common.vo.ResponseCode;
import lombok.Getter;

@Getter
public class DaoException extends BaseException {
    public DaoException(ResponseCode responseCode) {
        super(responseCode);
    }
}
