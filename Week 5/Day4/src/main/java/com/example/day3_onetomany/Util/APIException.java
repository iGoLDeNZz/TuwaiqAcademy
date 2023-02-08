package com.example.day3_onetomany.Util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class APIException extends RuntimeException {

    private String message;
    private Integer status;
}
