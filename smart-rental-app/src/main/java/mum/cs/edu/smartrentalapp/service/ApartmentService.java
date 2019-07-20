package mum.cs.edu.smartrentalapp.service;

import mum.cs.edu.smartrentalapp.domain.SearchFIlter;
import mum.cs.edu.smartrentalapp.domain.apartment.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ApartmentService {
    @Autowired
    private RestTemplate restTemplate;

    private final String apartmentUrl = "http://localhost:8081/api/apartments/{id}";
    private final String apartmentAllByIdUrl = "http://localhost:8081/api/apartments/all/";
    private final String apartmentListUrl = "http://localhost:8081/api/apartments";

    public List<Apartment> getApartments(){
        ResponseEntity<List<Apartment>> response = restTemplate.exchange(apartmentListUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Apartment>>() {
                });
        return response.getBody();
    }

    public List<Apartment> getApartmentsByVendorId(Long id){
        ResponseEntity<List<Apartment>> response = restTemplate.exchange(apartmentAllByIdUrl+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Apartment>>() {
                });
        return  response.getBody();
    }
    public List<Apartment> filterList(SearchFIlter filter){
        String zip=filter.getZipcode();
        String min=filter.getMin_price();
        String max=filter.getMax_price();
        String filterUrl="http://localhost:8081/api/apartments/filteredapartments/"+zip+"/"+min+"/"+max+"";
        System.out.println("URI *****************************"+filterUrl);
        ResponseEntity<List<Apartment>> response =
                restTemplate.exchange( filterUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Apartment>>() {});
        return response.getBody();
    }

    public void save(Apartment apartment){
        restTemplate.postForObject(apartmentListUrl,apartment,Apartment.class);
    }

    public Apartment get(Long id){
        return restTemplate.getForObject(apartmentUrl,Apartment.class,id);
    }
    public void delete(Long id){
        restTemplate.delete(apartmentUrl, id);
    }

}
