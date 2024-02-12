package com.walle.webnoteadmin.service.impl;

import com.walle.webnoteadmin.entity.User;
import com.walle.webnoteadmin.mapper.UserMapper;
import com.walle.webnoteadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
