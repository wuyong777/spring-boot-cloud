package com.walle.webnoteadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class WebnoteAdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebnoteAdminApplication.class, args);
    }

}
