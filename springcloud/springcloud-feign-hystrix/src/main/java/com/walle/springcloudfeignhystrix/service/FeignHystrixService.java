package com.walle.springcloudfeignhystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "eureka-client",fallback = FeignHystrixServiceImpl.class)
public interface FeignHystrixService {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam String name);

    }


