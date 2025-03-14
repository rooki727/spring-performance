package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SelfAssessment implements Serializable {
    private Integer self_assessment_id;
    private Integer user_id;
    private Integer indicator_id;
    private Double score;
    private String assess_type;
    private String basis;
    private String assessment_date;
    private String update_date;
}
