package com.walle.webnoteadmin.entity;

import com.walle.webnoteadmin.common.BaseEntity;
import lombok.Data;

@Data
public class UserInfo extends BaseEntity {
    private String address;
    private String phone;

}
