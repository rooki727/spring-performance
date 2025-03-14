package com.linyinlu.entity;



import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResponse<T> implements Serializable {
    private String code;
    private String msg;
    private Integer totalCount;
    private T data;

    // Getters and setters
}