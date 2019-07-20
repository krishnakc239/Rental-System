package mum.cs.edu.smartrentalapp.service;


import mum.cs.edu.smartrentalapp.domain.Hotel;
import mum.cs.edu.smartrentalapp.domain.SearchFIlter;

import java.util.List;

public interface HotelService  {


    List<Hotel> getAll();
    List<Hotel> filterList(SearchFIlter filter);
    Hotel getOne(long id);

    Hotel update(Hotel hotel,long id);
}
