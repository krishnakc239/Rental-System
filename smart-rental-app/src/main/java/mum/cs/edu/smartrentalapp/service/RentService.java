package mum.cs.edu.smartrentalapp.service;

import mum.cs.edu.smartrentalapp.domain.rent.Payment;
import mum.cs.edu.smartrentalapp.domain.rent.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RentService {
    @Autowired
    RestTemplate restTemplate;
    private final String url="http://localhost:8084/addRent/";
    private final String url2="http://localhost:8084/addPayment/";
    public Rent add(Rent rent){
        return restTemplate.postForObject(url,rent,Rent.class);

    }

    public Payment add(Payment payment){
        return restTemplate.postForObject(url2,payment,Payment.class);

    }



}
