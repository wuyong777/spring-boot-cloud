package com.walle.webnoteadmin;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebnoteAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebnoteAdminApplication.class, args);
    }

}
