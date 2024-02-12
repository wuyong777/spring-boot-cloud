package com.walle.webnoteadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.walle.webnoteadmin.common.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class Article extends BaseEntity {
    private String title;
    private String content;
    private Category category;
    private List<Tag> tags;
}
