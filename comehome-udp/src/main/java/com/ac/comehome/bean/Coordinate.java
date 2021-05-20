package com.ac.comehome.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: testredis
 * @description: 用户的坐标对象
 * @author: ErFeng_V
 * @create: 2021-05-15 13:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Coordinate {
    /**
     * 用户的x和y的坐标
     */
    private BigDecimal appX;
    private BigDecimal appY;
    /**
     * 用户的安卓标识
     */
    private String androidID;

    /**
     * 坐标的时间点
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date appDate;
}
