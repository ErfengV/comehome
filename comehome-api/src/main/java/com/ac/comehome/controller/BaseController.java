package com.ac.comehome.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;

/**
 * @program: comehome
 * @description: 基础控制器
 * @author: ErFeng_V
 * @create: 2021-04-18 14:52
 */
public class BaseController {
    //只需要加上下面这段即可，注意不能忘记注解
    /* 自定义日期转换格式 */
    @InitBinder
    public void InitBinder (ServletRequestDataBinder binder){
        binder.registerCustomEditor(java.util.Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)
        );
    }
}
