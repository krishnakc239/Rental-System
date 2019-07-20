package com.solam.ea.solam_rent.controller;



import com.solam.ea.solam_rent.dao.RentDAO;
import com.solam.ea.solam_rent.domain.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RentController {


    @Autowired
    private RentDAO service;


    //add new rent
    @PostMapping(value = "/addRent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rent addRent(@RequestBody Rent rent){
        return service.save(rent);
    }

    //list all the rents
    @GetMapping("/rents")
    public List<Rent> getAllRents(){
        return service.findAll();
    }

    //find rent by productId
    @GetMapping("/rent/{id}")
    public Rent getRentByProductId(@PathVariable long id){
        return service.findRentByAccessoriesId(id);
    }

    //Find all rents by customerId
    @GetMapping("/rentByCustId/{id}")
    public List<Rent> getRentsByCustomerId(@PathVariable long id){
        return service.findRentByCustomerId(id);
    }

    //Find all rents by vendorId
//    @GetMapping("/rentByVendId/{id}")
//    public List<Rent> getRentsByVendorId(@PathVariable long id){
//        return service.findRentByVendorId(id);
//    }

    //Find all rents by rented date
    @GetMapping("/rentByRentStart/{rentFrom}")
    public List<Rent> getRentsByRentedDate(@PathVariable String rentFrom){

        List<Rent> result=new ArrayList<>();
        try {
            Date rentedDate=new SimpleDateFormat("yyyy-MM-dd").parse(rentFrom);
            System.out.println(rentedDate);
            result= service.findRentsByRentFromEquals(rentedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //Find all rents by expected returning date
    @GetMapping("/rentByRentEnd/{rentTo}")
    public List<Rent> getRentsByExpectedReturnDate(@PathVariable String rentTo){

        List<Rent> result=new ArrayList<>();
        try {
            Date rentedDate=new SimpleDateFormat("yyyy-MM-dd").parse(rentTo);
            System.out.println(rentedDate);
            result= service.findRentsByRentToEquals(rentedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
