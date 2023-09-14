package com.example.cs203g1t3.Exceptions;

import org.springframework.beans.factory.annotation.Autowired;

public class UsernameNotFoundException extends RuntimeException{
    @Autowired
    public UsernameNotFoundException(String message){
        super(message);
    }
}
