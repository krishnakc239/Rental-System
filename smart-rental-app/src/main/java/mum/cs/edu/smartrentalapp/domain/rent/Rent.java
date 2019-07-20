package mum.cs.edu.smartrentalapp.domain.rent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rent {
    private Long id;

    private long customerId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentTo;


    private String message;


    private double price;

    private long accessoriesId;

}
