package com.linyinlu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Research implements Serializable {
    private Integer research_id;
    private String category;
    private String sub_type;
    private String level;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh", timezone = "GMT+8")
    private Date start_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh", timezone = "GMT+8")
    private Date end_date;
    private Double funding;
    private String publisher;
    private String ranking;
    private String is_authorized;
    private String description;
    private Integer user_id;
    private String created_date;
    private String check_status;
    private String real_name;
    private String file_link;
}

