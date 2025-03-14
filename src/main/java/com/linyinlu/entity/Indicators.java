package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Indicators implements Serializable {
    private Integer indicator_id;
    private String indicator_name;
    private Double weight;
    private String created_at;
    private String updated_at;
}
