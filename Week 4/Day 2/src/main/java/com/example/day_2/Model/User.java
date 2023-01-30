package com.example.day_2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;


    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, message = "Name must be longer than 4 characters.")
    @Column(columnDefinition = "varchar(30) not null CHECK ( LENGTH(name)>4 )")
    private String name;


    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 5, message = "username must be longer than 4 characters.")
    @Column(columnDefinition = "varchar(30) not null CHECK (LENGTH(username)>4) unique")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "Must be a valid email pattern.")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotEmpty(message = "role cannot be empty")
    @Column(columnDefinition = "varchar(5) not null check ( role='admin' or role='user')")
    private String role;

    @NotNull(message = "Age is required.")
    @Column(columnDefinition = "int not null check (age>0)")
    private Integer age;
}
