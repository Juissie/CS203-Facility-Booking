package com.example.cs203g1t3.services;

import java.util.*;
import org.springframework.stereotype.Service;

import com.example.cs203g1t3.models.Customer;
import com.example.cs203g1t3.repository.CustomerRepository;

@Service
public class CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }   

    public Customer registerCustomer(String name, String password, String email) {
        if (name == null  || password == null) {
            return null;
        } else {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setPassword(password);
            customer.setEmail(email);
            return customerRepository.save(customer);
        }
    }

    public Customer authenticate(String name, String password) {
        Optional<Customer> customer = customerRepository.findByNameAndPassword(name, password);
        if  (customer.isPresent()) {
            return customer.get();
        }
        return null;
    }
}
