package com.walle.webnoteadmin.mapper;

import com.walle.webnoteadmin.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("select * from t_userinfo where user_id=#{uid}")
    UserInfo findUserInfoByUid(int uid);
}
