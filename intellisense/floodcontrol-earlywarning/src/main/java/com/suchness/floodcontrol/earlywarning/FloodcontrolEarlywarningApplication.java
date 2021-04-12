package com.suchness.floodcontrol.earlywarning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.suchness.floodcontrol.earlywarning.dao")
public class FloodcontrolEarlywarningApplication {

    public static void main(String[] args) {
        SpringApplication.run(FloodcontrolEarlywarningApplication.class, args);
    }

}
