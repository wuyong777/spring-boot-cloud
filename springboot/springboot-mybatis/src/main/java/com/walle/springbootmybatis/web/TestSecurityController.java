package com.walle.springbootmybatis.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {
    @GetMapping("/hello")
    public String hello(){
        return "hello springboot security";
    }
}
