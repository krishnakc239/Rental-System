package mum.cs.edu.smartrentalapp.service;

import mum.cs.edu.smartrentalapp.domain.Mycar;
import mum.cs.edu.smartrentalapp.domain.SearchFIlter;
import mum.cs.edu.smartrentalapp.domain.apartment.Apartment;
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
public class MyCarServiceImpl implements  MyCarService {
    @Autowired
    RestTemplate restTemplate;

    private final String carsURL="http://localhost:8083/mycar/cars";
   // private final String filterCars="http://localhost:8083/mycar/filteredcars/{filter}";
    private final String carURL="http://localhost:8083/mycar/cars/{id}";
    private final String carsAllByIdUrl = "http://localhost:8083/mycar/cars/all/";
//    private final String carListUrl = "http://localhost:8081/api/cars";




    @Override
    public List<Mycar> getAll() {
        ResponseEntity<List<Mycar>> response =
                restTemplate.exchange(carsURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Mycar>>() {});
        return response.getBody();
    }


    @Override
    public List<Mycar> filterList(SearchFIlter filter){
        String zip=filter.getZipcode();
        String min=filter.getMin_price();
        String max=filter.getMax_price();
        String filterUrl="http://localhost:8083/mycar/filteredcars/"+zip+"/"+min+"/"+max+"";
        System.out.println("URI *****************************"+filterUrl);
        ResponseEntity<List<Mycar>> response =
                restTemplate.exchange( filterUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Mycar>>() {});
        return response.getBody();
    }
//
//    @Override
//    public Mycar getSingleCar(Long id) {
//        return restTemplate.getForObject(carURL,Mycar.class,id);
//    }


    public Mycar get(Long id) {
        return restTemplate.getForObject(carURL, Mycar.class, id);
    }

    @Override
    public void save(Mycar car) {
        System.out.println("car going to be saved !!!!");
       restTemplate.postForObject(carsURL,car,Mycar.class);
    }
//
    @Override
    public void delete(Long id) {

        restTemplate.delete(carURL,id);
    }
    public List<Mycar> getCarsByVendorId(Long id){
        ResponseEntity<List<Mycar>> response = restTemplate.exchange(carsAllByIdUrl+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Mycar>>() {
                });
        return  response.getBody();
    }
//
//    @Override
//    public void update(Mycar car) {
//      carRepository.save(car);
//    }
//
//    @Override
//    public Mycar get(Long id) {
//
//        return  carRepository.findById(id).get();
//    }
}
