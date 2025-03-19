package com.linyinlu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class SocialService implements Serializable {
    private Integer service_id;
    private String title;
    private String funding_source;
    private Double funding_amount;
    // 设置日期格式为“yyyy-MM-dd”
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh", timezone = "GMT+8")
    private Date agreement_date;
    private String level;
    // 设置日期格式为“yyyy-MM-dd”
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh", timezone = "GMT+8")
    private Date report_time;
    private String report_ranking;
    private String created_date;
    private Integer user_id;
    private String check_status;
    private String real_name;
    private String file_link;
}

