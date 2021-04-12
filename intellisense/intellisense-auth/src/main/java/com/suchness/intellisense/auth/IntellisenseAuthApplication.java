package com.suchness.intellisense.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.suchness.intellisense")
public class IntellisenseAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntellisenseAuthApplication.class, args);
    }

}
