package mum.cs.edu.smartrentalapp.domain.rent;



import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Long id;

    private String CVC;


    private String cardNo;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate expDate;
    private String expDate;

    private String expMonth;


    private String nameOnCard;


    private long customerId;

    private long rentId;
}

