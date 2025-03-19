package com.linyinlu.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Research implements Serializable {
    private Integer research_id;
    private String category;
    private String sub_type;
    private String level;
    private String title;
    private Date start_date;
    private Date end_date;
    private Double funding;
    private String publisher;
    private Integer ranking;
    private Integer is_authorized;
    private String description;
    private Integer user_id;
    private String created_date;
    private String check_status;
    private String real_name;
    private String file_link;
}

