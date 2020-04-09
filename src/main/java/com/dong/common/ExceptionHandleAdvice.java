package com.dong.common;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常统一处理
 *
 * @author LD
 */
@RestControllerAdvice
public class ExceptionHandleAdvice {

    /**
     * BindException异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseResult BindExceptionHandler(BindException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return ResponseResult.error(objectError.getDefaultMessage());
    }
}
