package com.walle.springcloudfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
//声明要调用的服务名
@FeignClient("eureka-client")
public interface FeignService {
    //声明要调用的服务的接口  例如：eureka-client服务的/hello接口
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
     String hello(@RequestParam String name);
}
