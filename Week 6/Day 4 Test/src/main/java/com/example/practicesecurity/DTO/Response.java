package com.example.practicesecurity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Response {
    private String message;
    private Integer status;
}
