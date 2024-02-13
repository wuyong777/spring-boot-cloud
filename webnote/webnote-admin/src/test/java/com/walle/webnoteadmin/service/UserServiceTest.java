package com.walle.webnoteadmin.service;

import com.walle.webnoteadmin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    //因为Mapper层已经测试好了，所以@Mock模拟该Mapper
    @Mock
    private UserMapper userMapper;

    @Test
    void testFindAllUser() {
    }
}