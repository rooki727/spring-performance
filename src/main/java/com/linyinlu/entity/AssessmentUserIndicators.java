package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AssessmentUserIndicators implements Serializable {
    private Integer self_assessment_id;
    private Integer user_id;
    private String real_name;
    private Integer indicator_id;
    private String indicator_name;
    private Double score;
    private String assess_type;
    private String basis;
    private String assessment_date;
}
