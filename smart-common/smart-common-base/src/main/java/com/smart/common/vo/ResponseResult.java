package com.smart.common.vo;

import lombok.Data;

/**
 * @author zhangwei
 */
@Data
public class ResponseResult<T> {
    private String msg;
    private Integer status;
    private T data;

    private ResponseResult() {
    }

    public static <T> ResponseResult<T> success(T data) {
        return success(ResponseCode.SUCCESS, data);
    }

    public static <T> ResponseResult<T> success(ResponseCode responseCode, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setData(data);
        responseResult.setStatus(ResponseCode.SUCCESS.getStatus());
        responseResult.setMsg(ResponseCode.SUCCESS.getMsg());
        return responseResult;
    }


    public static <T> ResponseResult<T> error(ResponseCode responseCode) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setStatus(responseCode.getStatus());
        responseResult.setMsg(responseCode.getMsg());
        return responseResult;
    }

    public static <T> ResponseResult<T> error() {
        return error(ResponseCode.ERROR);
    }

    public static <T> ResponseResult<T> error(T data) {
        ResponseResult<T> result = error(ResponseCode.ERROR);
        result.setData(data);
        return result;
    }
}
