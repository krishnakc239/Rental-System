package mum.cs.edu.smartrentalapp.service;

import mum.cs.edu.smartrentalapp.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    private final String authUrl = "http://localhost:8080/auth/authenticate";
    private final String userAddUrl = "http://localhost:8080/auth/addUser";
    private final String usersUrl = "http://localhost:8080/auth/users";

    public List<User> getUsers(){
        ResponseEntity<List<User>> response = restTemplate.exchange(usersUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                });
        return response.getBody();
    }

    public User authenticate(User user){
        User autheticatedUser = restTemplate.postForObject(authUrl,user,User.class);
        System.out.println("returned user ="+ autheticatedUser);
        return autheticatedUser;
    }
    public void add(User u){
        restTemplate.postForObject(userAddUrl,u,User.class);

    }

//    public void registerUser(User user){
//        restTemplate.postForObject(authUrl,user,User.class);
//    }
}
