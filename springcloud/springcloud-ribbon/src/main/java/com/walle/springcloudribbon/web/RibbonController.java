package com.walle.springcloudribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {
    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/ribbonhello", method = RequestMethod.GET)
    public String hello() {
        return restTemplate.getForEntity("http://eureka-client/hello?name=walle", String.class).getBody();
    }

}
