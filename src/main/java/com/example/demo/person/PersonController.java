package com.example.demo.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping
    List<Person> getPerson(){
        return personRepository.findAll();
    }

    @GetMapping(path = "{personId}")
    public Optional<Person> getSpecificPerson(@PathVariable("personId") Long personId){
        boolean exists = personRepository.existsById(personId);
        if(!exists){
            throw new IllegalStateException("Person with id " + personId + " does not exists");
        }
        return personRepository.findById(personId);
    }

    @PostMapping
    public void createPerson(@RequestBody Person person){
        Optional<Person> personOptional = personRepository
                .findPersonByName(person.getName());
        if (personOptional.isPresent()){
            throw new IllegalStateException("person name taken");
        }
        personRepository.save(person);

    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long personId){
        boolean exists = personRepository.existsById(personId);
        if(!exists){
            throw new IllegalStateException("Person with id " + personId + " does not exists");
        }
        personRepository.deleteById(personId);
    }
}
