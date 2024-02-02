package com.walle.springbootmybatis.service;


import com.walle.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    int add(User user);

    List<User> findAllUser();

    int update(User user);

    int deleteById(@Param("id") Long id);
}
