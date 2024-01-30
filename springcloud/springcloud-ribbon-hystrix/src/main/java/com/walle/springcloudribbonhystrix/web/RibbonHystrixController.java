package com.walle.springcloudribbonhystrix.web;

import com.walle.springcloudribbonhystrix.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonHystrixController {
    @Autowired
    RibbonHystrixService ribbonHystrixService;

    @RequestMapping(value = "/ribbonhystrixhello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name") String name) {
        return ribbonHystrixService.hello(name);
    }
}
