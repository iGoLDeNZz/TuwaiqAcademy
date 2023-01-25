package com.example.week3_day4__validation.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
public class Employee {

    @NotNull(message = "id is required")
    @Size(min = 3, message = "ID has to be longer than 3 digits")
    private String id;

    @NotNull(message = "Name is required")
    @Size(min = 5, message = "Name has to be at least 4 Characters")
    private String name;


    @Min(value = 26, message = "Employee has to be at lest 26 years old.")
    @NotNull(message = "Age is required")
    private int age;

    @NotNull(message = "Role is required")
    @Pattern(regexp = "\\b(supervisor|coordinator)\\b", message = "Role must be supervisor or coordinator (CASE SENCITIVE)")
    private String role;

    @NotNull(message = "Leave is required")
    @AssertFalse(message = "Employee cannot be on leave at the start")
    private boolean onLeave;

    @NotNull(message = "Employment year is required")
    @Min(value = 2010, message = "Employment year has to be from 2010 up until today.")
    @Max(value = 2023)
    private int employmentYear;

    @NotNull(message = "Annual leave is required")
    @PositiveOrZero
    private int annualLeave;
}
