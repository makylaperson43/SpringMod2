package com.example.demo.person;

import com.example.demo.airline.Airline;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@JsonIgnoreProperties
public class Person {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long id;

    private String name;

    private String age;

    private String tickets;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledPeople")
    private Set<Airline> airlines = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Airline> getAirlines(){
        return airlines;
    }

}
