package com.ac.comehome.config;

/**
 * @program: comehome
 * @description: 图片路径配置
 * @author: ErFeng_V
 * @create: 2021-03-31 17:02
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class PicConfig implements WebMvcConfigurer {

    public String file="file:///d:";
    

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //设置web的路径
        registry.addResourceHandler("/**")
                //设置本地目录路径
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/task_img/**")
                .addResourceLocations(file+"/task_img/");

        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/doc.html");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

}
