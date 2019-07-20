package mum.edu.mycar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Mycar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private String make;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate year;
    private double price_per_day;
    @Column(name="registration_number")
    private Long registrationNumber;
    @Column(name="last_service_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastServiceDate;
    private String image_url;
    @Embedded
    private Address address;

    private double service_charge;
    private double security_deposit;
    private String rent_policy;
    private String gear;
    private int seat;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate available_from;
    private String description;
    private Long vendorId;
    private String category;
    private String contact;


    public Mycar(String name, String model, String make, LocalDate year, double price_per_day, Long registrationNumber, LocalDate lastServiceDate, String image_url, double service_charge, double security_deposit, String rent_policy, String gear, int seat, LocalDate available_from,String description,Long vendorId, String category, String contact) {
        this.name = name;
        this.model = model;
        this.make = make;
        this.year = year;
        this.price_per_day = price_per_day;
        this.registrationNumber = registrationNumber;
        this.lastServiceDate = lastServiceDate;
        this.image_url = image_url;
        this.service_charge = service_charge;
        this.security_deposit = security_deposit;
        this.rent_policy = rent_policy;
        this.gear = gear;
        this.seat = seat;
        this.available_from = available_from;
        this.description=description;
        this.contact = contact;
        this.vendorId = vendorId;
        this.category = category;
    }

}
