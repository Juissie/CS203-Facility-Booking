package com.example.cs203g1t3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cs203g1t3.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Added dependency for UsernameNotFoundException
    @Override
        public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found"));
    }
    
    //Important: Please only include methods such as makeBooking or cancelBooking AND NOT LOG IN OR REGISTER METHOD
    // as they are placed in the authenticationservice

    //Should not include any registering or log in service function here
//    public User registerCustomer(String username, String password, String email) {
//        if (username == null  || password == null) {
//            return null;
//        } else {
//            User user = new User();
//            user.setUsername(username);
//            user.setPassword(password);
//            user.setEmail(email);
//            return userRepository.save(user);
//        }
//    }

    //Should not include any registering or log in service function here
//    public User authenticate(String username, String password) {
//        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
//        return user.orElse(null);
//    }



}
