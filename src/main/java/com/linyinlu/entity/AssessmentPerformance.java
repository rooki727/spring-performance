package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AssessmentPerformance implements Serializable {
    private Integer performance_id;
    private Integer user_id;
    private Double total_score;
    private String performance_date;
    private String real_name;
    private List<Assessment> assessmentList;
}
