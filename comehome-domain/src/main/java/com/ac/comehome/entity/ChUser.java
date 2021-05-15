package com.ac.comehome.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;


/**
 * @program: comehome
 * @description: 用户类
 * @author: ErFeng_V
 * @create: 2021-04-11 15:00
 * @RequiredArgsConstructor也是在类上使用，
 * 但是这个注解可以生成带参或者不带参的构造方法。
 * 若带参数，只能是类中所有带有 @NonNull注解的和以final修饰的未经初始化的字段，
 */

@Entity(name = "ch_user")
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Data
@ApiModel(value="用户对象模型")
public class ChUser extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户主键",example = "123")
    private Long uId;


    @ApiModelProperty(value = "用户的OpenId",example = "XXXXX")
    private String uOpenid;


    @ApiModelProperty(value = "用户昵称",example = "张三")
    private String uNickname;



    @ApiModelProperty(value = "用户头像",example = "http://1.png")
    private String uAvator;



    @ApiModelProperty(value = "用户性别",example = "男")
    private String uSex;



    @ApiModelProperty(value = "用户所在省",example = "XX省")
    private String uProvince;


    @ApiModelProperty(value = "用户所在城市",example = "XX市")
    private String uCity;


    @ApiModelProperty(value = "用户电话",example = "150xxxxxxxxx")
    private String uTel;


    @ApiModelProperty(value = "用户状态",example = "1")
    private Integer uState;


    @ApiModelProperty(value = "是否是志愿者",example = "1")
    private Integer uIsvol;


    @ApiModelProperty(value = "志愿者的身份证号",example = "1234567899999999")
    private String uIdcard;

//    @Transient
//    @ApiModelProperty(value = "监护人的设备信息")
//    private List<ChEquipment> equipments;

//    @Transient
//    @ApiModelProperty(value = "监护人发布的求救信息")
//    private List<ChTask> tasks;

    public ChUser(String uOpenid){
        this.uOpenid=uOpenid;
    }

    public ChUser(String uOpenid,Integer uIsvol, String uIdcard) {
        this.uIsvol = uIsvol;
        this.uOpenid=uOpenid;
        this.uIdcard = uIdcard;
    }

    public ChUser(String uOpenid, String uNickname, String uAvator, String uSex, String uProvince, String uCity, String uTel) {
        this.uOpenid = uOpenid;
        this.uNickname = uNickname;
        this.uAvator = uAvator;
        this.uSex = uSex;
        this.uProvince = uProvince;
        this.uCity = uCity;
        this.uTel = uTel;

    }
}
