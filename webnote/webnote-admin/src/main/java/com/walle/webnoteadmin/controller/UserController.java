package com.walle.webnoteadmin.controller;

import com.walle.webnoteadmin.entity.User;
import com.walle.webnoteadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAllUser")
    public List<User> FindAllUser() {
        return userService.findAllUser();
    }
}
