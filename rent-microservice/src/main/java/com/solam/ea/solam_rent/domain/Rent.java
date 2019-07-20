package com.solam.ea.solam_rent.domain;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private long customerId;

//    @NotNull
//    @Temporal(TemporalType.DATE)
    private LocalDate rentFrom;

//    @NotNull
//    @Temporal(TemporalType.DATE)
    private LocalDate rentTo;

    @NotNull
    private String message;

    @NotNull
    private double price;

//    @NotNull
//    private long vendorId;

    @NotNull
    private long accessoriesId;


    public Rent(@NotNull long customerId, @NotNull LocalDate rentFrom, @NotNull LocalDate rentTo, @NotNull long accessoriesId) {
        this.customerId = customerId;
        this.accessoriesId = accessoriesId;
        this.rentFrom=rentFrom;
        this.rentTo=rentTo;
    }
}
