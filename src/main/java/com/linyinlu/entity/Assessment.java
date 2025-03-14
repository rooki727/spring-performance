package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Assessment implements Serializable {
    private Integer assessment_id;
    private Integer indicator_id;
    private String indicator_name;
    private Double score;
    private String assessment_type;
    private String basis;
    private String assessment_date;
    private Integer performance_id;
}
