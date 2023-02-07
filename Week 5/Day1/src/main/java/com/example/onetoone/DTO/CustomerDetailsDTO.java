package com.example.onetoone.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsDTO {

    private Integer customerId;
    private Integer age;
    private String phoneNumber;
    private String gender;

}
