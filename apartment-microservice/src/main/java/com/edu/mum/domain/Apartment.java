package com.edu.mum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String category;
    @NotNull
    private String name;
    @NotNull
    private double rentPerMonth;
    @NotNull
    private String description;
    private Long vendorId;
//apartment adress
    private String country;
    private String state;
    private String city;
    private String street;
    private String zip;
    private String contact;
    private String image_url;
    private int room_num;
}
