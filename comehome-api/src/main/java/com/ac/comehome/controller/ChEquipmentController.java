package com.ac.comehome.controller;

import com.ac.comehome.annotation.ResponseResult;
import com.ac.comehome.entity.ChEquipment;
import com.ac.comehome.entity.Coordinate;
import com.ac.comehome.entity.Result;
import com.ac.comehome.entity.ResultError;
import com.ac.comehome.enums.ResultCode;
import com.ac.comehome.service.impl.ChEquipmentServiceImpl;
import com.ac.comehome.util.MongodbUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @program: comehome
 * @description:
 * @author: ErFeng_V
 * @create: 2021-04-17 15:03
 */
@Api(value = "归家行动的API",tags = "关于设备的API")
@RestController
@RequestMapping("/chEquipment")
@ResponseResult
@CrossOrigin
public class ChEquipmentController extends BaseController implements Serializable{


    private static final long serialVersionUID = 1197176400261468602L;

    private ChEquipmentServiceImpl chEquipmentService;

    @Autowired
    public void setChEquipmentService(ChEquipmentServiceImpl chEquipmentService) {
        this.chEquipmentService = chEquipmentService;
    }


    /**
     * 进行设备绑定
     * @param eOther
     * @param eCreatetime
     * @param uId
     * @return
     */
    @Async
    @PostMapping("/bind")
    @ApiOperation(value="绑定设备",  httpMethod = "POST",  produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "eOther", value = "其他绑定账号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "eCreatetime", value = "绑定时间", required = true, dataType = "Date"),
            @ApiImplicitParam(paramType="query", name = "uId", value = "绑定人员", required = true, dataType = "Long"),
            @ApiImplicitParam(paramType="query", name = "eDesc", value = "设备描述", required = false, dataType = "String"),

    })
    public CompletableFuture<ChEquipment> bind(@RequestParam("eOther")String eOther,
                                          @RequestParam("eCreatetime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date eCreatetime,
                                          @RequestParam("uId")Long uId,
    @RequestParam("eDesc")String eDesc) {
        return CompletableFuture.supplyAsync(() -> {
            ChEquipment chEquipment=new ChEquipment(eOther,eCreatetime,uId,eDesc);
            chEquipment.setEState(1);//启用该设备
            if(chEquipmentService.bindEqui(chEquipment)){
                return chEquipment;
            }
            throw new ResultError(ResultCode.WRONG_EQUIPMENT_BIND);
        });
    }




    @Async
    @PostMapping("/stop")
    @ApiOperation(value="停用该设备",  httpMethod = "POST",  produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "eId", value = "设备的eId", required = true, dataType = "Long")
    })
    public CompletableFuture<Result> stop(@RequestParam("eId")Long eId) {
        return CompletableFuture.supplyAsync(() -> {
            ChEquipment chEquipment=new ChEquipment(0,eId);
            if(chEquipmentService.closeEqui(chEquipment)){
                return Result.success("停用该设备操作成功");
            }
            throw new ResultError(ResultCode.SQL_DELETE_FAIL);
        });
    }

    @Async
    @PostMapping("/updateDesc")
    @ApiOperation(value="修改设备描述信息",  httpMethod = "POST",  produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "eId", value = "设备的eId", required = true, dataType = "Long"),
            @ApiImplicitParam(paramType="query", name = "eDesc", value = "设备的描述信息", required = true, dataType = "String")
    })
    public CompletableFuture<Result> updateDesc(@RequestParam("eId")Long eId,@RequestParam("eDesc")String eDesc) {
        return CompletableFuture.supplyAsync(() -> {
            ChEquipment chEquipment=new ChEquipment(eDesc,eId);
            if(chEquipmentService.updateDescEqui(chEquipment)){
                return Result.success("设备描述信息修改成功");
            }
            throw new ResultError(ResultCode.SQL_DELETE_FAIL);
        });
    }

    @Async
    @PostMapping("/provideCoor")
    @ApiOperation(value="查询所有的坐标",  httpMethod = "POST",  produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "eId", value = "设备的eId", required = true, dataType = "Long"),
            @ApiImplicitParam(paramType="query", name = "openID", value = "用户的openID", required = true, dataType = "String")
    })
    public CompletableFuture<List> provideCoor(@RequestParam("eId")Long eId,@RequestParam("uId") Long uId
            ,@RequestParam("eOther")String eOther) {
        return CompletableFuture.supplyAsync(() -> {
            ChEquipment chEquipment=new ChEquipment(uId,eId);
            if(chEquipmentService.checkEqui(chEquipment)){
                List<Coordinate> coordinates= MongodbUtil.findAll(Coordinate.class,eOther);
                return coordinates;
            }
            throw new ResultError(ResultCode.COMMON_EMPTY_CONDITION_RESULT);
        });
    }



}
