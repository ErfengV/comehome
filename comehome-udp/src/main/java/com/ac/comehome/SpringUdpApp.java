package com.ac.comehome;

/**
 * @program: comehome
 * @description:
 * @author: ErFeng_V
 * @create: 2021-04-18 19:44
 */


import com.ac.comehome.handler.UdpDecoderHandler;
import com.ac.comehome.handler.UdpEncoderHandler;
import com.ac.comehome.handler.UdpHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.netty.udp.UdpServer;

import java.time.Duration;

@ServletComponentScan
@SpringBootApplication
public class SpringUdpApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringUdpApp.class, args);
    }
    @Bean
    CommandLineRunner serverRunner(UdpDecoderHandler udpDecoderHanlder, UdpEncoderHandler udpEncoderHandler, UdpHandler udpHandler) {
        return strings -> {
            createUdpServer(udpDecoderHanlder, udpEncoderHandler, udpHandler);
        };
    }

    /**
     *
     * 创建UDP Server
     * @param udpDecoderHandler： 用于解析UDP Client上报数据的handler
     * @param udpEncoderHandler： 用于向UDP Client发送数据进行编码的handler
     * @param udpHandler: 用户维护UDP链接的handler
     */
    private void createUdpServer(UdpDecoderHandler udpDecoderHandler, UdpEncoderHandler udpEncoderHandler, UdpHandler udpHandler) {
        UdpServer.create()
                .handle((in,out) -> {
                    in.receive()
                            .asByteArray()
                            .subscribe();
                    return Flux.never();
                })
                //UDP Server端口
                .port(8888)
                .doOnBound(conn -> conn
                        .addHandler("decoder",udpDecoderHandler)
                        .addHandler("encoder", udpEncoderHandler)
                        .addHandler("handler", udpHandler)
                ) //可以添加多个handler
                .bindNow(Duration.ofSeconds(30));
    }
}
