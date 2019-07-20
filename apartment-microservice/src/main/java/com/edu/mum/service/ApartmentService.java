package com.edu.mum.service;

import com.edu.mum.dao.ApartmentDao;
import com.edu.mum.domain.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentDao apartmentDao;


    public List<Apartment> getAllFilteredApartment(String zip,double min,double max) {
        return apartmentDao.getAllFilteredApartment(zip,min,max);
    }


    public List<Apartment> getAll() {
        return apartmentDao.findAll();
    }

    public void add(Apartment book) {
        apartmentDao.save(book);
    }

    public Apartment get(Long id) {
        return apartmentDao.findById(id).get();
    }

    public List<Apartment> findAllByVendorId(Long id){
        return apartmentDao.findAllByVendorId(id);
    }

    public void update(Apartment book) {
        apartmentDao.save(book);
    }

    public void delete(Long id) {
        apartmentDao.deleteById(id);
    }
}
