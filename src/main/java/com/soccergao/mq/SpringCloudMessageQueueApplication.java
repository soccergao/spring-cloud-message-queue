package com.soccergao.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudMessageQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMessageQueueApplication.class, args);
    }

}

