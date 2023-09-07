package com.example.cs203g1t3.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cs203g1t3.models.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByUsernameAndPassword(String username, String password);
}
