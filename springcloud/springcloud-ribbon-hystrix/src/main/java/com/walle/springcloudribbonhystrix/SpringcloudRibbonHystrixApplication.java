package com.walle.springcloudribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class SpringcloudRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbonHystrixApplication.class, args);
    }
    @Bean
    //@LoadBalanced 开启负载均衡能力
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
