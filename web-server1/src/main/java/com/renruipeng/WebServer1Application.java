package com.renruipeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WebServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(WebServer1Application.class, args);
    }

}
