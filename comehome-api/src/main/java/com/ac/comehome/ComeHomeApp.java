package com.ac.comehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: comehome
 * @description: comehome启动类
 * @author: ErFeng_V
 * @create: 2021-04-17 13:36
 */
@SpringBootApplication

public class ComeHomeApp {
    public static void main(String[] args) {
        SpringApplication.run(ComeHomeApp.class,args);
    }
}
