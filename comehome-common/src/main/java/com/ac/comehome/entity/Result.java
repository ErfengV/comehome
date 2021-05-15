package com.ac.comehome.entity;

import com.ac.comehome.enums.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="返回结果的对象模型")
public class Result implements Serializable {

    @ApiModelProperty(value = "响应码",example = "6000")
    private Integer code;
    @ApiModelProperty(value = "消息")
    private String message;
    @ApiModelProperty(value = "响应对象")
    private Object data;

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message=resultCode.message();
        this.data=data;
    }

    //返回成功
    public static Result success(){
        Result result=new Result(ResultCode.SUCCESS,null);
        return result;
    }

    public static Result success(Object data){
        Result result=new Result(ResultCode.SUCCESS,data);
        return result;
    }

    //返回失败
    public static Result failure(ResultCode resultCode){
        Result result=new Result(resultCode,null);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data){
        Result result=new Result(resultCode,data);
        return result;
    }
}
