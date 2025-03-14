package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherPerformance implements Serializable {
    private Integer performance_id;
    private Integer user_id;
    private Double total_score;
    private String performance_date;
}
