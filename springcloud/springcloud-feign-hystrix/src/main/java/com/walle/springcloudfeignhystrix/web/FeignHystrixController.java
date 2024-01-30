package com.walle.springcloudfeignhystrix.web;

import com.walle.springcloudfeignhystrix.service.FeignHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHystrixController {

    @Autowired
     FeignHystrixService feignHystrixService;

    @RequestMapping(value = "/feignhystrixhello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name") String name) {

        return feignHystrixService.hello(name);
    }
}
