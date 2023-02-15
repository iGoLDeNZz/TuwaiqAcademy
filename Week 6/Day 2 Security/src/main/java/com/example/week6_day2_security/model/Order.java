package com.example.week6_day2_security.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(columnDefinition = "int")
    private Integer quantity;

    @NotNull
    private double totalPrice;

    @NotNull
    private Status status;


    private Date dateReceived;

    @ManyToOne
    @JoinColumn(name = "user_Id", referencedColumnName = "id")
    @JsonIgnore
    private User user;


    @ManyToMany
    private Set<Product> products;
}
