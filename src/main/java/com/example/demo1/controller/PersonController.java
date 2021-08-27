package com.example.demo1.controller;

import com.example.demo1.model.Person;
import com.example.demo1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void insertPerson(@RequestBody Person person){
        personService.insertPerson(person);
    }

    @GetMapping
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @GetMapping(path = "{id}")
    public Person personById(@PathVariable("id") Long id){
        return personService.personById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") Long id){
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id")Long id,@NonNull @RequestBody Person person){
        personService.updatePerson(id, person);
    }
}
