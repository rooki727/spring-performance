package com.linyinlu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.io.Serializable;
import java.sql.Date;

@Data
public class User implements Serializable {

    private Integer user_id;
    private Integer account;
    private String password;
    private String avatar;
    private String role;
    private String academy;
    private String gender;
    private String real_name;
    private String email;
    private String phone_number;
    private String created_at;
    private String updated_at;
    private String token;
    private String refreshToken;
}
