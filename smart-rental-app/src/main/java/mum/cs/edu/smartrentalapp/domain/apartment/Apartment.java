package mum.cs.edu.smartrentalapp.domain.apartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
    private Long id;
    private String category;
    private String name;
    private double rentPerMonth;
    private String description;
    private Long vendorId;
    private String image_url;
    private String room_num;
    //apartment adress
    private String country;
    private String state;
    private String city;
    private String street;
    private String zip;
    private String contact;
}
