package com.walle.springbootmybatis.service.impl;

import com.walle.springbootmybatis.entity.User;
import com.walle.springbootmybatis.mapple.UserMapple;
import com.walle.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapple userMapple;


    @Override
    public int add(User user) {
        return this.userMapple.add(user);
    }

    @Override
    public List<User> findAllUser() {
        return this.userMapple.findAllUser();
    }

    @Override
    public int update(User user) {
        return this.userMapple.update(user);
    }

    @Override
    public int deleteById(Long id) {
        return this.userMapple.deleteById(id);
    }
}
