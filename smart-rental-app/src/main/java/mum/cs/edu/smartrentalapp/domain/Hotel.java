package mum.cs.edu.smartrentalapp.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private long id;

    private String name;

    private String contact;
    private String email;
    private String website;
    private String image_url;
    private String description;
    private long vendor_id;
    private double price;
    private int is_rented;

    private Address address;


}
