package com.mum.edu.service;

import com.mum.edu.domain.User;
import com.mum.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String uname, String pword){
        return userRepository.findDistinctByUsernameAndPassword(uname,pword);
    }

//    @Autowired
//    private UserRepository userRepository;


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
