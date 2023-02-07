package com.example.onetoone.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class CustomerDetails {

    @Id
    private Integer id;
    private Integer age;
    private String phoneNumber;
    private String gender;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;
}
