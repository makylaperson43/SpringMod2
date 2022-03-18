package com.example.demo.pilot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilot")
public class PilotController {
    @Autowired
    PilotRepository pilotRepository;

    @GetMapping
    List<Pilot> getPilot(){
        return pilotRepository.findAll();
    }

    @PostMapping
    Pilot createPilot(@RequestBody Pilot pilot){
        return pilotRepository.save(pilot);
    }

    @DeleteMapping(path = "{pilotId}")
    public void deletePilot(@PathVariable("pilotId") Long pilotId){
        boolean exists = pilotRepository.existsById(pilotId);
        if(!exists) {
            throw new IllegalStateException(
                    "pilot with id " + pilotId + " does not exists");
        }
        pilotRepository.deleteById(pilotId);
    }
    
}
