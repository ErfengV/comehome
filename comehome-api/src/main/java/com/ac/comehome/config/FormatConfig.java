package com.ac.comehome.config;

import com.ac.comehome.Interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: comehome
 * @description: 格式配置
 * @author: ErFeng_V
 * @create: 2021-04-18 14:49
 */
@Configuration
public class FormatConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ResponseResultInterceptor());
        super.addInterceptors(registry);
    }


}
