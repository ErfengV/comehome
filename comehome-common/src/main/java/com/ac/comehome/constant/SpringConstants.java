package com.ac.comehome.constant;

import org.springframework.beans.factory.annotation.Value;

/**
 * @program: comehome
 * @description: 通过注入的常量
 * @author: ErFeng_V
 * @create: 2021-04-17 20:34
 */
public class SpringConstants {

    /**
     * fastdfs部分
     */
    @Value("${file.path.head}")
    public static String PATHHEAD ;
    
}
