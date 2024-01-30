package com.walle.springcloudfeign.web;

import com.walle.springcloudfeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/feignhello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name") String name) {

        return feignService.hello(name);
    }
}
