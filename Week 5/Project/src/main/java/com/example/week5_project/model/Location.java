package com.example.week5_project.model;

import com.example.week5_project.DTO.LocationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Location {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotEmpty
    private String area;

    @NotEmpty
    private String street;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;

    public Location(LocationDTO locationDTO, Store store){
        this.area = locationDTO.getArea();
        this.street = locationDTO.getStreet();
        this.store = store;
    }
}
