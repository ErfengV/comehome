package com.ac.comehome.controller;

import com.ac.comehome.annotation.ResponseResult;
import com.ac.comehome.entity.ChUser;
import com.ac.comehome.entity.Result;
import com.ac.comehome.entity.ResultError;
import com.ac.comehome.enums.ResultCode;
import com.ac.comehome.service.impl.ChUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * @program: comehome
 * @description: 用户C
 * @author: ErFeng_V
 * @create: 2021-04-17 13:39
 */
@Api(value = "归家行动的API",tags = "关于用户的API")
@RestController
@RequestMapping("/chUser")
@CrossOrigin
@ResponseResult
public class ChUserController extends BaseController implements Serializable {


    private static final long serialVersionUID = 2605880250259090856L;

    private ChUserServiceImpl chUserService;

    @Autowired
    public void setChUserService(ChUserServiceImpl chUserService) {
        this.chUserService = chUserService;
    }

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
            chUser=chUserService.login(chUser);
            if(chUser!=null){
                return chUser;
            }
            //@TODO:错误处理
            throw new ResultError(ResultCode.WRONG_ACCOUNT_OR_PWD);
            //return null;
            //return Result.failure(ResultCode.WRONG_ACCOUNT_NO_OPENID);
        });
    }






    /**
     * 用户授权
     * @param uOpenid
     * @param uNickname
     * @param uAvator
     * @param uSex
     * @param uProvince
     * @param uCity
     * @param uTel
     * @return
     */
    @Async
    @PostMapping("/authorize")
    @ApiOperation(value="用户授权",  httpMethod = "POST",  produces = "application/json")//必须要
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "uOpenid", value = "用户的openid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "uNickname", value = "用户昵称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "uAvator", value = "用户头像", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "uSex", value = "用户性别", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "uProvince", value = "用户所在省", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "uCity", value = "用户所在城市", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "uTel", value = "用户电话", required = true, dataType = "String")
    })
    public CompletableFuture<ChUser> register(@RequestParam("uOpenid")String uOpenid,
                                              @RequestParam("uNickname")String uNickname,
                                              @RequestParam("uAvator")String uAvator,
                                              @RequestParam(value = "uSex")String uSex,
                                              @RequestParam("uProvince")String uProvince,
                                              @RequestParam("uCity")String uCity,
                                              @RequestParam("uTel")String uTel) {
        return CompletableFuture.supplyAsync(() -> {
           ChUser chUser=new ChUser(uOpenid, uNickname, uAvator, uSex, uProvince, uCity, uTel);
           chUser.setUState(1);
           if (chUserService.isRegister(chUser)){
               throw new ResultError(ResultCode.WRONG_ACCOUNT_YES_OPENID);
           }
           if(chUserService.register(chUser)){
               return  chUser;
           }
            throw new ResultError(ResultCode.WRONG_ACCOUNT_OPENID);
        });
    }

    @Async
    @PostMapping("/apply")
    @ApiOperation(value="申请志愿者",  httpMethod = "POST",  produces = "application/json")//必须要
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "openid", value = "用户的openid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "uIsvol", value = "是否是志愿者", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "uIdcard", value = "用户的身份证信息", required = true, dataType = "String")
    })
    public CompletableFuture<Result> applyForVolunteer(@RequestParam("openid")String openid,
                                                       @RequestParam("uIsvol")Integer uIsvol,
                                                       @RequestParam("uIdcard")String uIdcard) {
        return CompletableFuture.supplyAsync(() -> {
            if ("".equals(openid)|| uIsvol == null || "".equals(uIdcard)){
                throw new ResultError(ResultCode.COMMON_PARAMS_INVALID);
            }
            if(uIsvol !=0){
                throw new ResultError(ResultCode.COMMON_PARAMS_INVALID,"你已经是志愿者啦");
            }

            ChUser chUser=new ChUser(openid,1, uIdcard);

            if(chUserService.updateIsvol(chUser)){
                return Result.success("申请成功");
            }
           throw new ResultError(ResultCode.SQL_UPDATE_FAIL);

        });
    }
}
