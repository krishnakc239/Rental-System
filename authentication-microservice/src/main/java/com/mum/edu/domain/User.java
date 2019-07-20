package com.mum.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
    private String country;
    private String state;
    private String city;
    private String street;
    private String zip;
    private String contact;
    private String email;
    private String phone;
    private String mailBox;
//    @Embedded
//    private Address address;
//    @Embedded
//    private Contact contact;
}
