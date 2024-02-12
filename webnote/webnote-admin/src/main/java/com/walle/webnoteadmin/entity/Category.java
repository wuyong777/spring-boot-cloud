package com.walle.webnoteadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.walle.webnoteadmin.common.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class Category extends BaseEntity {
    private String name;
    private List<Article> articles;
}
