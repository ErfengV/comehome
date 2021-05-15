package com.ac.comehome.controller;

import com.ac.comehome.annotation.ResponseResult;
import com.ac.comehome.client.impl.FastefsClient;
import com.ac.comehome.entity.ChTask;
import com.ac.comehome.entity.ResultError;
import com.ac.comehome.enums.ResultCode;
import com.ac.comehome.service.impl.ChTaskServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @program: comehome
 * @description:
 * @author: ErFeng_V
 * @create: 2021-04-17 15:03
 */
@Api(value = "归家行动的API",tags = "关于任务的API")
@RestController
@RequestMapping("/chTask")
@CrossOrigin
@ResponseResult
public class ChTaskController extends BaseController implements Serializable {


    private static final long serialVersionUID = -3714151850370040594L;

    private FastefsClient fastefsClient;
    private ChTaskServiceImpl chTaskService;

    @Autowired
    public void setFastefsClient(FastefsClient fastefsClient) {
        this.fastefsClient = fastefsClient;
    }

    @Autowired
    public void setChTaskService(ChTaskServiceImpl chTaskService) {
        this.chTaskService = chTaskService;
    }

//    @Async
//    @PostMapping("/publishInfo")
//    @ApiOperation(value="用户发布求救信息",  httpMethod = "POST",  produces = "application/json")//必须要
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "tName", value = "走丢者的姓名", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "tSex", value = "走丢者的性别", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "tAge", value = "走丢者的年龄", required = true, dataType = "int"),
//            @ApiImplicitParam(paramType="query", name = "tPhoto", value = "走丢的者的照片", required = true, dataType = "file"),
//            @ApiImplicitParam(paramType="query", name = "tAddr", value = "走丢的地址", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "tDesc", value = "关于走丢者的描述", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "tCreatetime", value = "发布日期", required = true, dataType = "Date"),
//            @ApiImplicitParam(paramType="query", name = "uId", value = "发布者主键", required = true, dataType = "Long"),
//    })
//    public CompletableFuture<Result> publishInfo(@RequestParam("tName") String tName, @RequestParam("tSex") String tSex,
//                                                 @RequestParam("tAge") Integer tAge, @RequestPart("tPhoto") MultipartFile[] tPhoto,
//                                                 @RequestParam("tAddr") String tAddr, @RequestParam("tDesc")  String tDesc,
//                                                 @RequestParam("tCreatetime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date tCreatetime, @RequestParam("uId") Long uId) {
//        return CompletableFuture.supplyAsync(() -> {
//            //上传文件,为了获取路径
//            StringBuffer stringBuffer=new StringBuffer();
//
//           // FileHandleUtil.createDirIfNotExists("/task_img");
//            for (int i=0;i<tPhoto.length;i++){
//                String dFileName = UUID.randomUUID()+tPhoto[i].getOriginalFilename().
//                        substring(tPhoto[i].getOriginalFilename().lastIndexOf("."));
//                try {
//                    if(tPhoto[i].isEmpty()){
//                        //@TODO:文件若为空怎么处理
//                    }else {
//                        tPhoto[i].transferTo(new File("/task_img/" + dFileName));
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                stringBuffer.append("task_img/"+dFileName+",");
//            }
////            for(int i=0;i<tPhoto.length;i++) {
////                stringBuffer.append(SpringConstants.PATHHEAD+fastefsClient.uplodFile(tPhoto[i]) + ",");
////            }
//
//            String tPhotopath=stringBuffer.toString();
//            ChTask chTask=new ChTask(tName,tSex,tAge,tPhotopath,tAddr,tDesc,tCreatetime,uId);
//            if(chTaskService.publishTask(chTask)){
//                return Result.success(chTask);
//            }
//            return Result.failure(ResultCode.SQL_INSERT_FAIL);
//        });
//    }

    @Async
    @PostMapping(value = "/publishInfo")
    @ApiOperation(value="用户发布求救信息",  httpMethod = "POST",   produces = "application/json",notes = "tPhotopath是文件路径")//必须要
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "tName", value = "走丢者的姓名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "tSex", value = "走丢者的性别", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "tAge", value = "走丢者的年龄", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query",  name = "tPhotopath", value = "走丢的者的照片", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "tAddr", value = "走丢的地址", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "tDesc", value = "关于走丢者的描述", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "tCreatetime", value = "发布日期", required = true, dataType = "Date"),
            @ApiImplicitParam(paramType="query", name = "uId", value = "发布者主键", required = true, dataType = "Long"),
    })
    public CompletableFuture<ChTask> taskPublishInfo(@RequestParam(value = "tName") String tName, @RequestParam(value = "tSex") String tSex,
                                                 @RequestParam(value = "tAge") Integer tAge,@RequestParam("tPhotopath") String tPhotopath,
                                                 @RequestParam("tAddr") String tAddr, @RequestParam("tDesc")  String tDesc,
                                                 @RequestParam("tCreatetime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date tCreatetime, @RequestParam("uId") Long uId) {
        return CompletableFuture.supplyAsync(() -> {

            ChTask chTask=new ChTask(tName,tSex,tAge,tPhotopath,tAddr,tDesc,tCreatetime,uId);
            if(chTaskService.publishTask(chTask)){
                return chTask;
            }
           throw new ResultError(ResultCode.INVALID_PARAMS);
        });
    }

    @Async
    @PostMapping("/uploadfile")
    @ApiOperation(value="上传图片",  httpMethod = "POST")//必须要
    public CompletableFuture<String> taskUploadfile(@RequestParam("tPhoto") MultipartFile tPhoto) {
        return CompletableFuture.supplyAsync(() -> {
            //上传文件,为了获取路径
            StringBuffer stringBuffer=new StringBuffer();
            String dFileName = UUID.randomUUID()+tPhoto.getOriginalFilename().
                    substring(tPhoto.getOriginalFilename().lastIndexOf("."));
            if(tPhoto.isEmpty()){
                //@TODO:文件若为空怎么处理
                throw new ResultError(ResultCode.FILE_NOT_FOUND);
            }else {
                try {
                    tPhoto.transferTo(new File("/task_img/" + dFileName));
                } catch (IOException e) {
                    throw new ResultError(ResultCode.COMMON_ERROR,e.getMessage());
                }
            }
            stringBuffer.append("task_img/"+dFileName);
            String tPhotopath=stringBuffer.toString();
            return tPhotopath;
        });
    }




}
