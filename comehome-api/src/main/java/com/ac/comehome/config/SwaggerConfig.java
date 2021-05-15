package com.ac.comehome.config;


import com.ac.comehome.entity.ChUser;
import com.ac.comehome.entity.Result;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.concurrent.CompletableFuture;

/**
 * @author 帅气的二峰
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Value("${swagger.enabled}")
    private boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .ignoredParameterTypes(String.class,CompletableFuture.class, File.class, InputStream.class, Resource.class, URI.class, URL.class, URLStreamHandler.class)
                .enable(swaggerEnabled)
                .groupName("微信小程序端的CRUD")
                .select()
                //Controller所在包(必须新建包)
                .apis(RequestHandlerSelectors.basePackage("com.ac"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //接口文档的名字
                .title("归家 api")
                //接口文档的描述
                .description("归家 api接口文档")
                //服务条款网址
                .termsOfServiceUrl("http://123.0.0.1/")
                //接口文档的版本
                .version("1.0.0")
                // 接口文档维护联系信息
                .contact(new Contact("ACTeam", "", "3208027182@qq.com"))
                .build();
    }
}
