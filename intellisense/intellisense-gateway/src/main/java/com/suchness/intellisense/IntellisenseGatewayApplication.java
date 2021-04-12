package com.suchness.intellisense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class IntellisenseGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntellisenseGatewayApplication.class, args);
    }

}
