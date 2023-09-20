package com.example.cs203g1t3.models;

import com.example.cs203g1t3.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
//import javax.validation.constraints.*;


@Entity
@Table(name = "users", schema="public")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

//    Login Details
    private String username;
    @NotBlank
//    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;
    @NotBlank
    // We define two roles/authorities: ROLE_USER or ROLE_ADMIN
    private String authorities;

//    //Other non-important identifiers
     private String address;
     @Email
     private String email;
     private Integer phoneNumber;
     private boolean accountStatus;
     private LocalDateTime lastActive;

//    //Variables to be used in the service later on
    private int creditScore;
    private int noOfBookingsLeft;
    private boolean isMember;



    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(authorities));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // implement method
//    public boolean makeBooking() {
//        return true;
//    }
//
//    // implement method
//    public List<Booking> listBooking() {
//        return null;
//    }

//    @Override
//    // Password omitted
//    public String toString() {
//        return "Account [userID=" + userID + ", accountStatus=" + accountStatus + ", lastActive=" + lastActive
//                + ", name=" + username + ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
//    }
    
}
