package mum.edu.mycar.repository;

import mum.edu.mycar.domain.Mycar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository  extends JpaRepository<Mycar,Long> {
  @Query("SELECT distinct mc From Mycar mc  Where mc.address.zip=?1 and mc.price_per_day>=?2 and mc.price_per_day<=?3")
    List<Mycar> getAllFilteredCar(String zip,double min,double max);

  @Query("from Mycar mc where mc.vendorId =?1")
  public List<Mycar> findAllByVendorId(Long id);


}
