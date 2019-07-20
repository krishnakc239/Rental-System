package com.edu.mum.dao;

import com.edu.mum.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentDao extends JpaRepository<Apartment,Long> {
    @Query("from apartment a where a.vendorId =?1")
    public List<Apartment> findAllByVendorId(Long id);

    @Query("SELECT distinct mc From apartment mc  Where mc.zip=?1 and mc.rentPerMonth>=?2 and mc.rentPerMonth<=?3")
    List<Apartment> getAllFilteredApartment(String zip,double min,double max);
}
