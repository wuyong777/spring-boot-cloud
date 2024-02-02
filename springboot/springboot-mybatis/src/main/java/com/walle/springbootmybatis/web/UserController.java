package com.walle.springbootmybatis.web;

import com.walle.springbootmybatis.entity.User;
import com.walle.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping(value = "/add")
    public int add(User user) {
        return this.userService.add(user);
    }

    @GetMapping(value = "/findAllUser")
    public List<User> findAllUser() {
        return this.userService.findAllUser();
    }

    @GetMapping(value = "/update")
    public int update(User user) {
        return this.userService.update(user);
    }

    @GetMapping(value = "/deleteById")
    public int deleteById(Long id) {
        return this.userService.deleteById(id);
    }

}
