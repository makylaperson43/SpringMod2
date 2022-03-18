package com.example.demo.pilot;

import com.example.demo.airline.Airline;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy  = "pilot")
    private Set<Airline> airlines;

    private String name;

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    private String years;


    public Long getId(){return id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public Set<Airline> getAirlines() {
        return airlines;
    }
}
