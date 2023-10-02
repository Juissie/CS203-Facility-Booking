package com.example.cs203g1t3.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "facility")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

// LocalDateTime reference : 
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/package-summary.html


public class Facility {

    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long facilityId;
    private String facilityType;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime openTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endTime;
    private boolean isCurrentlyBooked;
    private String description;

    public Facility(String facilityType, String description) {
        this.facilityType = facilityType;
        this.description = description;
    }



}
