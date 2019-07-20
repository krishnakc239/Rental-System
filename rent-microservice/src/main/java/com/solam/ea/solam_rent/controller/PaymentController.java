package com.solam.ea.solam_rent.controller;

import com.solam.ea.solam_rent.dao.PaymentDAO;
import com.solam.ea.solam_rent.domain.Payment;
import com.solam.ea.solam_rent.domain.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentDAO service;

    //add new payment
    @PostMapping(value = "/addPayment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Payment addNewPayment(@RequestBody Payment payment){
        return service.save(payment);
    }

    //list all the payments
    @GetMapping("/payments")
    public List<Payment> getAllPayments(){
        return service.findAll();
    }

    //find payment by productId
    @GetMapping("/paymentByRent/{id}")
    public Payment getPaymentByRentId(@PathVariable long id){
        return service.findPaymentByRentId(id);
    }

    //Find all rents by customerId
    @GetMapping("/paymentByCustomer/{id}")
    public List<Payment> getRentsByCustomerId(@PathVariable long id){
        return service.findPaymentsByCustomerId(id);
    }
}
