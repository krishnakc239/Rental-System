package mum.cs.edu.smartrentalapp.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mycar {
    private Long id;
    private Long vendorId;
    private String category;
    private String name;
    private String model;
    private String make;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate year;
    private double price_per_day;
    private Long registrationNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate lastServiceDate;
    private String image_url;
    private Address address;

    private double service_charge;
    private double security_deposit;
    private String rent_policy;
    private String gear;
    private int seat;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate available_from;
    private String description;
    private String contact;


    public String getState() {
        return this.address.getState();
    }

    public void setState(String state) {
        this.address.setState(state);
    }

    public String getCity() {
        return this.address.getCity();
    }

    public void setCity(String city) {
        this.address.setCity(city);
    }

    public String getStreet() {
        return this.address.getStreet();
    }

    public void setStreet(String street) {
        this.address.setStreet(street);
    }

    public String getZip() {
        return this.address.getZip();
    }

    public void setZip(String zip) {
        this.address.setZip(zip);
    }


}
