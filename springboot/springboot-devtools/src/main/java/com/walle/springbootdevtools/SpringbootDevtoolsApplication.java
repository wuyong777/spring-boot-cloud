package com.walle.springbootdevtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDevtoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDevtoolsApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world....";
    }
}
