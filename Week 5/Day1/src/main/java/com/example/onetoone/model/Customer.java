package com.example.onetoone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;

}
