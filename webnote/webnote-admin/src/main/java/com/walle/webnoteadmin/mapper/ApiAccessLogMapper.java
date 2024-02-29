package com.walle.webnoteadmin.mapper;

import com.walle.webnoteadmin.entity.ApiAccessLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApiAccessLogMapper {

    @Insert("INSERT INTO t_apiaccesslog(method, path, params, ip) VALUES(#{method}, #{path}, #{params}, #{ip})")
    void insertApiAccessLog(ApiAccessLog apiAccessLog);
}