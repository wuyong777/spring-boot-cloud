package com.walle.springcloudfeignhystrix.service;

import org.springframework.stereotype.Component;

@Component
public class FeignHystrixServiceImpl implements FeignHystrixService {
    @Override
    public String hello(String name) {
        return "sorry " + name + ", something error!";
    }
}
