package com.renruipeng.webserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.renruipeng.feign"})
public class WebServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(WebServer2Application.class, args);
    }

}
