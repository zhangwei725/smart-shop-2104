package com.smart.common.handler;

import com.smart.common.exception.BaseException;
import com.smart.common.exception.ControllerException;
import com.smart.common.exception.DaoException;
import com.smart.common.exception.ServiceException;
import com.smart.common.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseResult<Object> handler(BaseException ex) {
        log.error(ex.getMsg());
        return ResponseResult.error(ex.getResponseCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handler(Exception ex) {
        log.error(ex.getMessage());
        return ResponseResult.error();
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseResult<Object> handler(ServiceException ex) {
        log.error(ex.getMsg());
        return ResponseResult.error(ex.getResponseCode());
    }


    @ExceptionHandler(DaoException.class)
    public ResponseResult<Object> handler(DaoException ex) {
        log.error(ex.getMsg());
        return ResponseResult.error(ex.getResponseCode());
    }

    @ExceptionHandler(ControllerException.class)
    public ResponseResult<Object> handler(ControllerException ex) {
        log.error(ex.getMsg());
        return ResponseResult.error(ex.getResponseCode());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult<String> handlerMethodArgumentNotValidHandler(
            MethodArgumentNotValidException exception) throws Exception {
        //按需重新封装需要返回的错误信息
        StringBuffer sb = new StringBuffer();
        //获取所有的参数校验的信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            sb.append(error.getDefaultMessage());
        }
        return ResponseResult.error(sb.toString());
    }
}
