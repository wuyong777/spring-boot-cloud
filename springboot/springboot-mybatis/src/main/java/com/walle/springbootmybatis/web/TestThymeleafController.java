package com.walle.springbootmybatis.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestThymeleafController {
    @GetMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "hi thymeleaf");
        return "index";
    }
}
