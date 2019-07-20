package com.edu.mum.controller;

import com.edu.mum.domain.Apartment;
import com.edu.mum.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/apartments")
    public List<Apartment> getAll() {
        return apartmentService.getAll();
    }

    @GetMapping("/apartments/all/{vendorId}")
    public List<Apartment> getAllByVendorId(@PathVariable("vendorId") Long id) {
        System.out.println("vendor id :"+ id);
        return apartmentService.findAllByVendorId(id);
    }

    @GetMapping("/apartments/{id}")
    public Apartment get(@PathVariable Long id) {
        Apartment apt=  apartmentService.get(id);
        return apt;
    }

    @PostMapping("/apartments")
    public RedirectView add(@RequestBody Apartment apartment) {
        apartmentService.add(apartment);
        return new RedirectView("/apartments/" + apartment.getId());
    }

    @PutMapping("/apartments/{id}")
    public void update(@RequestBody Apartment apartment) {
        apartmentService.update(apartment);
    }

    @DeleteMapping("/apartments/{id}")
    public void delete(@PathVariable Long id) {
        apartmentService.delete(id);
    }

    @GetMapping("apartments/filteredapartments/{zip}/{min}/{max}")
    public List<Apartment> getAllFilteredCar(Model model, @PathVariable String zip, @PathVariable String min, @PathVariable String max){
        Double min1=new Double(min);
        Double max1=new Double(max);
        return apartmentService.getAllFilteredApartment(zip,min1,max1);
    }
}
