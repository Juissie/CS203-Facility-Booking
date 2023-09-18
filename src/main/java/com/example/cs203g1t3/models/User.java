package com.example.cs203g1t3.models;
import java.util.*;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Size;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements UserDetails {

    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    private Integer userId;

//    @Enumerated(EnumType.STRING)
    private String authorities;

    @Setter
    @NonNull
    @Size(min = 9, message = "Username should be at least 9 letters long")
    private String username; //strictly meaning NRIC
    @Setter
    @NonNull
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;

    //Other important data to store for the user information
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private Integer phoneNumber;

    //used for booking availability and fair allocation algorithm
    @Getter
    @Setter
    private int creditScore;
    @Getter
    @Setter
    private int noOfBookingsLeft;
    @Getter
    @Setter
    private boolean isMember;

    public User(@NonNull String username, @NonNull String password,String authorities){
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    // implement method
    public boolean makeBooking() {
        return true;
    }

    // implement method
    public List<Booking> listBooking() {
        return null;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(authorities));
    }

    @Override
    public @NonNull String getPassword() {
        return password;
    }

    @Override
    public @NonNull String getUsername() {
        return username;
    }

    //getUsername() method has already been implemented in the Account class
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

    public List<String> searchAvailableFacilities(String facilityType) {
        return null;
    }

    @Override
    // Password omitted
    public String toString() {
        return "Account [userID=" + userId + ", accountStatus=" + /*accountStatus +*/ ", lastActive=" + /*lastActive
                + */", name=" + username + ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";

    }
}
