package com.example.day3_onetomany.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddressDTO {

    private Integer teacherId;
    private Integer buildingNumber;
    private String street;
    private String area;

}