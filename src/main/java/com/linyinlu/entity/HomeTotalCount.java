package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class HomeTotalCount implements Serializable {
    private String home_name;
    private Integer home_count;
}
