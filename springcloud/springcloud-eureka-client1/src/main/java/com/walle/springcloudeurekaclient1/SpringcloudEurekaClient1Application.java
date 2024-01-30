package com.walle.springcloudeurekaclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudEurekaClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaClient1Application.class, args);
    }

}
