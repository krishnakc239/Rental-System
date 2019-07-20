package mum.cs.edu.smartrentalapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String state;
    private String city;
    private String street;
    private String zip;

}
