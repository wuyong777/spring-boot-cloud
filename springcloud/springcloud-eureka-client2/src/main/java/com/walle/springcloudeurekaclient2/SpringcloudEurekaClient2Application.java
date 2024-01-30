package com.walle.springcloudeurekaclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudEurekaClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaClient2Application.class, args);
    }

}
