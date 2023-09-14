package com.example.cs203g1t3.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cs203g1t3.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);

}
