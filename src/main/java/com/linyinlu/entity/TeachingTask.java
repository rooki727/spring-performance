package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class TeachingTask implements Serializable {
    private Integer task_id;
    private String semester;
    private String course_name;
    private String class_type;
    private String class_name;
    private Integer credit_hours;
    private String created_date;
    private Integer user_id;
    private String check_status;
    private String real_name;
    private String file_link;
}
