package com.example.week4_day4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @SequenceGenerator(name = "id_seq", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @Id
    private Integer id;


    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must be longer than 2 characters.")
    @Column(columnDefinition = "varchar(30) not null CHECK ( LENGTH(name)>2 )")
    private String name;


    @NotEmpty(message = "genre cannot be empty")
    @Column(columnDefinition = "varchar(6) not null check ( genre='Drama' or genre='Action' or genre='Comedy')")
    private String genre;


    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    @Column(columnDefinition = "int check (rating >= 1 and rating <=5")
    private Integer rating;

    @Min(value = 60, message = "duration must be more than 60")
    @Column(columnDefinition = "int check (duration >= 60")
    private Integer duration;

    @NotNull(message = "director ID is required.")
    private Integer directorId;

}

