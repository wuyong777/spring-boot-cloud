package com.walle.webnoteadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.walle.webnoteadmin.common.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiAccessLog extends BaseEntity {
    private String method;
    private String path;
    private String params;
    private String ip;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime accessTime;
}