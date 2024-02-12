package com.walle.webnoteadmin.mapper;

import com.walle.webnoteadmin.entity.User;
import com.walle.webnoteadmin.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    @Results({
            @Result(property = "id",column = "id"),
            /*@Result(property = "userInfo",javaType = UserInfo.class,column = "id",
            one = @One(select = "com.walle.webnoteadmin.mapper.UserInfoMapper.findUserInfoByUid"))*/
    })
    List<User> findAllUser();
}
