package mum.cs.edu.smartrentalapp.service;

import mum.cs.edu.smartrentalapp.domain.Mycar;
import mum.cs.edu.smartrentalapp.domain.SearchFIlter;

import java.util.List;


public interface MyCarService {
    List<Mycar> getAll();

    List<Mycar> filterList(SearchFIlter filter);
//    Mycar getSingleCar(Long id);
    void save(Mycar car);
    void delete(Long id);
//    void update(Mycar car);
    Mycar get(Long id);
    List<Mycar> getCarsByVendorId(Long vid);
}
