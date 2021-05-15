package com.ac.comehome.handler;

import com.ac.comehome.entity.Result;
import com.ac.comehome.entity.ResultError;
import com.ac.comehome.enums.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: comehome
 * @description: 全局异常处理器
 * @author: ErFeng_V
 * @create: 2021-05-12 18:50
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //controller层的错误异常处理
    @ExceptionHandler(value = ResultError.class)
    @ResponseBody
    public Result controllerException(HttpServletRequest req, ResultError resultError){
        return Result.failure(resultError.getErrorCode(),resultError.getErrorMessage());
    }

//    //系统异常错误处理
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public Result bizException(HttpServletRequest req, Exception exception){
//        return Result.failure(ResultCode.SYSTEM_EXCEPTION,exception.getMessage());
//    }


}
