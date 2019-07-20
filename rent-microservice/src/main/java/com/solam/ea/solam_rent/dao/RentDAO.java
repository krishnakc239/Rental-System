package com.solam.ea.solam_rent.dao;



import com.solam.ea.solam_rent.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface RentDAO extends JpaRepository<Rent, Long> {

    List<Rent> findRentByCustomerId(long id);

//    List<Rent> findRentByVendorId(long id);

    List<Rent> findRentsByRentFromEquals(Date rentFrom);

    List<Rent> findRentsByRentToEquals(Date rentTo);

    Rent findRentByAccessoriesId(long id);

}
