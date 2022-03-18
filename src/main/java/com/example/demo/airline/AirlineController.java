package com.example.demo.airline;

import com.example.demo.person.Person;
import com.example.demo.person.PersonRepository;
import com.example.demo.pilot.Pilot;
import com.example.demo.pilot.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline")

public class AirlineController {
    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineController(AirlineRepository airlineRepository){
        this.airlineRepository = airlineRepository;
    }

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PilotRepository pilotRepository;

    @GetMapping
    List<Airline> getAirline(){
        return airlineRepository.findAll();
    }

    @PostMapping
    public void createAirline(@RequestBody Airline airline){
         airlineRepository.save(airline);
    }

    @PutMapping("/{airlineId}/person/{personId}")
    Airline addPersonToAirline(
            @PathVariable Long airlineId,
            @PathVariable Long personId
    ){
        Airline airline = airlineRepository.findById(airlineId).get();
        Person person = personRepository.findById(personId).get();
        airline.enrolledPeople.add(person);
        return airlineRepository.save(airline);
    }

    @PutMapping("/{airlineId}/pilot/{pilotId}")
    Airline assignPilotToAirline(
            @PathVariable Long airlineId,
            @PathVariable Long pilotId
    ){
        Airline airline = airlineRepository.findById(airlineId).get();
        Pilot pilot = pilotRepository.findById(pilotId).get();
        airline.setPilot(pilot);
        return airlineRepository.save(airline);
    }

    @DeleteMapping(path = "{airlineId}")
    public void deleteAirline(@PathVariable("airlineId")Long airlineId){
        boolean exists = airlineRepository.existsById(airlineId);
        if(!exists){
            throw new IllegalStateException("Airline with id " + airlineId + " does not exists");
        }
        airlineRepository.deleteById(airlineId);
    }
}
