package com.walle.webnoteadmin.service.impl;

import com.walle.webnoteadmin.entity.User;
import com.walle.webnoteadmin.mapper.UserMapper;
import com.walle.webnoteadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();


    }
}
