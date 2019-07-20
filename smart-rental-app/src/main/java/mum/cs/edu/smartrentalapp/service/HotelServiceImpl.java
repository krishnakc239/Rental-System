package mum.cs.edu.smartrentalapp.service;


import mum.cs.edu.smartrentalapp.domain.Hotel;
import mum.cs.edu.smartrentalapp.domain.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    RestTemplate restTemplate;



    private final String hotelsUrl ="http://localhost:8089/hotels";

    private final String hotelUrl ="http://localhost:8089/hotel/";


    @Override
    public List<Hotel> getAll() {

        ResponseEntity<List<Hotel>> response =
                restTemplate.exchange(hotelsUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Hotel>>() {});
        return response.getBody();
    }

    @Override
    public List<Hotel> filterList(SearchFilter filter) {
        String zip=filter.getZipcode();
        String min= String.valueOf(filter.getMin_price());
        String max= String.valueOf(filter.getMax_price());
        String filterUrl="http://localhost:8089/filteredHotels/"+zip+"/"+min+"/"+max+"";
        System.out.println("URI *****************************"+filterUrl);
        ResponseEntity<List<Hotel>> response =
                restTemplate.exchange( filterUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Hotel>>() {});
        return response.getBody();
    }

    @Override
    public Hotel getOne(long id) {
        String getOneHotel=hotelUrl+id;
        return restTemplate.getForObject(getOneHotel, Hotel.class,id);
    }

    @Override
    public Hotel update(Hotel hotel,long id) {
        String getUpdatedHotel=hotelUrl+"rent/"+id;
        return restTemplate.getForObject(getUpdatedHotel,Hotel.class,id);
    }
}
