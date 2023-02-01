package com.example.week4_day4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must be longer than 2 characters.")
    @Column(columnDefinition = "varchar(30) not null CHECK ( LENGTH(name)>2 )")
    private String name;

}
