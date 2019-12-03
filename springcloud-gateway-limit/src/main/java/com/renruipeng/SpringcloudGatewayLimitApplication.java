package com.renruipeng;

import com.renruipeng.config.HostAddrKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudGatewayLimitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayLimitApplication.class, args);
    }

    @Bean(value = "ipKeyResolver")
    public HostAddrKeyResolver hostAddrKeyResolver(){

        return new HostAddrKeyResolver();

    }

}
