package com.walle.webnoteadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.walle.webnoteadmin.common.BaseEntity;
import lombok.Data;

@Data
public class UserInfo extends BaseEntity {
    private String address;
    private String phone;

}
