package com.mum.edu.controller;

import com.mum.edu.domain.User;
import com.mum.edu.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/users")
    public List<User> getAll() {
        return authenticationService.getAll();
    }
        
    @GetMapping("/users/{id}")
    public User get(@PathVariable Long id) {
        User user=  authenticationService.get(id);
        return user;
    }

    @PostMapping(value = "/authenticate")
    public User authenticate(@RequestBody User u){
        return authenticationService.authenticate(u.getUsername(),u.getPassword());
    }

    @PostMapping(value = "/addUser")
    public RedirectView add(@RequestBody User user) {
        authenticationService.add(user);
        return new RedirectView("/users/" + user.getId());
    }

}
