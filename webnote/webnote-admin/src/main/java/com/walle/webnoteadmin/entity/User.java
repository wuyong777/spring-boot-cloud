package com.walle.webnoteadmin.entity;

import com.walle.webnoteadmin.common.BaseEntity;
import lombok.Data;

@Data
public class User extends BaseEntity {
    private String username;
    private String password;
    private UserInfo userInfo;
}
