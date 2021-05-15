package com.ac.comehome.handler;



import com.ac.comehome.annotation.ResponseResult;

import com.ac.comehome.constant.CommonConstants;
import com.ac.comehome.entity.Result;
import com.ac.comehome.entity.ResultError;
import com.ac.comehome.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 帅气的二峰
 */
@Slf4j
@RestControllerAdvice
public class RespnoseResultHandler implements ResponseBodyAdvice<Object> {


    /**
     * 是否请求，包含了包装注解 标记，没有就直接返回，不需要重写返回体
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request=sra.getRequest();
        //判断请求，是否有包装标记
        ResponseResult responseResultErFeng= (ResponseResult) request.getAttribute(CommonConstants.RESPONSE_RESULT_COMEHOME);
        return responseResultErFeng==null?false:true;

    }

    /**
     * //异常处理
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

//        判断是否为异常类
//        if(o instanceof ResultError){
//            ResultError errorResult= (ResultError) o;
//            return  Result.failure(errorResult.getErrorCode(),errorResult.getErrorMessage());
//        }
//        if(o instanceof Exception){
//            Exception errorResult= (Exception) o;
//            return  Result.failure(ResultCode.SYSTEM_EXCEPTION,errorResult.getMessage());
//        }
//        if(o instanceof RuntimeException){
//            ResultError errorResult= (ResultError) o;
//            return  Result.failure(errorResult.getErrorCode(),errorResult.getErrorMessage());
//        }

        //如果该类没有被包装过
        if(!(o instanceof Result)) {
            return Result.success(o);
        }
        return o;
    }
}
