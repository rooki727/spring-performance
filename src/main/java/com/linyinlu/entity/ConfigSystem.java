package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class ConfigSystem implements Serializable {
    private Integer config_id;
    private String config_name;
    private String config_value;
    private String create_time;
}
