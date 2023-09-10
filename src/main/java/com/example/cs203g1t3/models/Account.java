package com.example.cs203g1t3.models;

import java.time.LocalDateTime;
import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Getter @Setter private String password;
    @Getter @Setter private boolean accountStatus;
    @Getter @Setter private LocalDateTime lastActive;

    @Getter @Setter private String name;
    @Getter @Setter private String address;
    @Getter @Setter private String email;
    @Getter @Setter private Integer phoneNumber;
    

    
    // implement method
    public List<String> searchAvailableFacilities(String facilityType) {
        return null;
    }

    


    @Override 
    // Password omitted
    public String toString() {
        return "Account [userID=" + userID + ", accountStatus=" + accountStatus + ", lastActive=" + lastActive
                + ", name=" + name + ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
    }


    
    
     //setter
        // public void setUserID(String userID) {
        //     this.userID = userID;
        // }
        // public void setPassword(String password) {
        //     this.password = password;
        // }
        // public void setAccountStatus(boolean accountStatus) {
        //     this.accountStatus = accountStatus;
        // }
        // public void setLastActive(LocalDateTime lastActive) {
        //     this.lastActive = lastActive;
        // }
        // public void setName(String name) {
        //     this.name = name;
        // }
        // public void setAddress(String address) {
        //     this.address = address;
        // }
        // public void setEmail(String email) {
        //     this.email = email;
        // }
        // public void setPhoneNumber(String phoneNumber) {
        //     this.phoneNumber = phoneNumber;
        // }




    // //getter
        // public String getUserID() {
        //     return userID;
        // }
        // public String getPassword() {
        //     return password;
        // }
        // public boolean isAccountStatus() {
        //     return accountStatus;
        // }
        // public LocalDateTime getLastActive() {
        //     return lastActive;
        // }
        // public String getName() {
        //     return name;
        // }
        // public String getAddress() {
        //     return address;
        // }
        // public String getEmail() {
        //     return email;
        // }
        // public String getPhoneNumber() {
        //     return phoneNumber;
        // }

        
    
}
