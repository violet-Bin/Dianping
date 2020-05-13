package com.bingo.dianping.common;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:54 2020/5/13
 * @Description: 异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doError(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        if (ex instanceof BusinessException) {
            return Result.create(((BusinessException) ex).getCommonError(), "fail");
        } else if (ex instanceof NoHandlerFoundException) {
            CommonError commonError = new CommonError(ErrorCodeEnum.NO_HANDLER_FOUND);
            return Result.create(commonError, "fail");
        } else if (ex instanceof ServletRequestBindingException) {
            CommonError commonError = new CommonError(ErrorCodeEnum.BIND_EXCEPTION_ERROR);
            return Result.create(commonError, "fail");
        } else {
            CommonError commonError = new CommonError(ErrorCodeEnum.UNKNOWN_ERROR);
            return Result.create(commonError, "fail");
        }
    }


}
