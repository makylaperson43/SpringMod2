package com.example.demo.airline;


import com.example.demo.person.Person;
import com.example.demo.pilot.Pilot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    @ManyToMany
    @JoinTable(
            name="person_enrolled",
            joinColumns = @JoinColumn(name = "airline_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    Set<Person> enrolledPeople = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilot_id", referencedColumnName = "id")
    private Pilot pilot;



    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Set<Person> getAssignPerson() {

        return enrolledPeople;
    }

    public void enrollPerson(Person person) {
        enrolledPeople.add(person);
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

}
