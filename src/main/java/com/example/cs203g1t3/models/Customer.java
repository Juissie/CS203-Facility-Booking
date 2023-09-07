package com.example.cs203g1t3.models;
import java.util.*;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends Account{
    private int creditScore;
    private int noOfBookingsLeft;
    private boolean isMember;

    // implement method
    public boolean makeBooking() {
        return true;
    }

    // implement method
    public List<Booking> listBooking() {
        return null;
    }
    
}
