package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class AcademyPerformance implements Serializable {
    private String academy;
    private Integer user_count;
    private Double academy_total;

}
