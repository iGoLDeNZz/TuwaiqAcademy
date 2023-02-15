package com.example.week6_day2_security.Exception;

import lombok.Data;

@Data
public class APIException extends RuntimeException {

    private Integer status;

    public APIException(String message, Integer status){
        super(message);
        this.status = status;
    }
}
