package mum.edu.mycar.service;
import mum.edu.mycar.domain.Mycar;
import mum.edu.mycar.domain.SearchFilter;

import java.util.List;


public interface MyCarService {
    List<Mycar> getAll();
    List<Mycar> getAllFilteredCar(String zip,double min,double max);
    void save(Mycar car);
    void delete(Long id);
    void update(Mycar car);
    Mycar get(Long id);
    List<Mycar> findAllByVendorId(Long vid);

}
