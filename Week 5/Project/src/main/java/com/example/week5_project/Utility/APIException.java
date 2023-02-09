package com.example.week5_project.Utility;

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
