package com.walle.springbootmybatis.mapple;

import com.walle.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface UserMapple {

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int add(User user);

    @Select("SELECT * FROM USER")
    List<User> findAllUser();

    @Update("UPDATE USER SET age=#{age} WHERE name=#{name}")
    int update(User user);

    @Delete("DELETE FROM USER WHERE id = #{id}")
    int deleteById(@Param("id") Long id);

}

