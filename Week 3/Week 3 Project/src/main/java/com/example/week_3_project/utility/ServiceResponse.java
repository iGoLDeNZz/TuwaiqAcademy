package com.example.week_3_project.utility;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceResponse {

    private int status;
    private String message;
}
