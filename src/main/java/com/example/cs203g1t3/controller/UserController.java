package com.example.cs203g1t3.controller;

import com.example.cs203g1t3.models.User;
import java.util.List;
import javax.validation.Valid;

import com.example.cs203g1t3.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserRepository users;
    private BCryptPasswordEncoder encoder;

    public UserController(UserRepository users, BCryptPasswordEncoder encoder){
        this.users = users;
        this.encoder = encoder;
    }

    @PostMapping("/users") // i need help connecting this
    public User addUser(@Valid @RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return users.save(user);
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register_page";
    }

    @GetMapping("/login") 
    public String getLoginPage() {
        return "login_page";
    }


}

