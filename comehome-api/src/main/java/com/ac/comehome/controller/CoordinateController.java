package com.ac.comehome.controller;

import com.ac.comehome.annotation.ResponseResult;
import com.ac.comehome.entity.ChUser;
import com.ac.comehome.entity.ResultError;
import com.ac.comehome.enums.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * @program: comehome
 * @description: 坐标
 * @author: ErFeng_V
 * @create: 2021-05-15 14:44
 */
@Api(value = "归家行动的API",tags = "提供最近七天的行走路径")
@RestController
@RequestMapping("/chUser")
@CrossOrigin
@ResponseResult
public class CoordinateController {
    /**
     * 用户登录，传递openid
     * @param openid
     * @return
     */
    @Async
    @PostMapping("/login")
    @ApiOperation(value="用户登录",  httpMethod = "POST",  produces = "application/json")//必须要
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="openid", name = "openid", value = "用户的openid", required = true, dataType = "String")
    })
    public CompletableFuture<ChUser> login(@RequestParam("openid")  String openid) {
        return CompletableFuture.supplyAsync(() -> {
            ChUser chUser=new ChUser(openid);

            if(chUser!=null){
                return chUser;
            }
            //@TODO:错误处理
            throw new ResultError(ResultCode.WRONG_ACCOUNT_OR_PWD);
            //return null;
            //return Result.failure(ResultCode.WRONG_ACCOUNT_NO_OPENID);
        });
    }



}
