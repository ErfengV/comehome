package com.ac.comehome.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

/**
 * @program: comehome
 * @description: 发布寻找信息的POJO
 * @author: ErFeng_V
 * @create: 2021-04-11 15:01
 */
@Entity(name = "ch_task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value="任务对象模型")
public class ChTask extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "任务主键",example = "123")
    private Long tId;


    @ApiModelProperty(value = "走丢者姓名",example = "张三")
    private String tName;



    @ApiModelProperty(value = "走丢者性别",example = "张三")
    private String tSex;



    @ApiModelProperty(value = "走丢者的年龄",example = "123")
    private Integer tAge;



    @ApiModelProperty(value = "走丢者的照片路径，用','隔开",example = "XXX")
    private String tPhotopath;



    @ApiModelProperty(value = "走丢的地址",example = "XX省XX市XX县")
    private String tAddr;



    @ApiModelProperty(value = "对走丢者的描述",example = "海默")
    private String tDesc;



    @ApiModelProperty(value = "任务状态",example = "1")
    private String tState;


    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "任务创建时间",example = "2020-2-11 2:11:11")
    private Date tCreatetime;



    @ApiModelProperty(value = "监护人主键",example = "1")
    private  Long uId;

//    @Transient
//    @ApiModelProperty(value = "监护人")
//    private ChUser user;


    public ChTask(String tName, String tSex,
                  Integer tAge, String tPhotopath,
                  String tAddr, String tDesc,
                  Date tCreatetime, Long uId) {
        this.tName = tName;
        this.tSex = tSex;
        this.tAge = tAge;
        this.tPhotopath = tPhotopath;
        this.tAddr = tAddr;
        this.tDesc = tDesc;
        this.tCreatetime = tCreatetime;
        this.uId = uId;
    }
}
