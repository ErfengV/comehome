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
 * @description: 绑定设备信息
 * @author: ErFeng_V
 * @create: 2021-04-11 15:36
 */
@Entity(name = "ch_Equipment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value="设备对象模型")
public class ChEquipment extends BaseEntity{

    //@Column(name="e_id",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "设备主键",example = "123")
    private Long eId;



    @ApiModelProperty(value = "蓝牙",example = "12.a1.123")
    private String eBluetooth;



    @ApiModelProperty(value = "电话",example = "150XXXXXXX")
    private String eTel;



    @ApiModelProperty(value = "Android的Id",example = "XXXXX")
    private String eAndroid;


    @ApiModelProperty(value = "其他唯一标识",example = "XXXXX")
    private String eOther;


    @ApiModelProperty(value = "状态",example = "1")
    private Integer eState;

    @ApiModelProperty(value = "设备描述信息",example = "my father")
    private String eDesc;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "设备绑定的时间",example = "2020-2-11 12:12:12")
    private Date eCreatetime;



    @ApiModelProperty(value = "监护人的主键",example = "1")
    private  Long uId;



    public ChEquipment(String eOther,Date eCreatetime,Long uId,String eDesc){
        this.eOther=eOther;
        this.eCreatetime=eCreatetime;
        this.uId=uId;
        this.eDesc=eDesc;
    }

    public ChEquipment(Integer eState,Long eId){
        this.eState=eState;
        this.eId=eId;
    }

    public ChEquipment(String eDesc,Long eId){
        this.eDesc=eDesc;
        this.eId=eId;
    }
    public ChEquipment(Long uId,Long eId){
        this.uId=uId;
        this.eId=eId;
    }


}
