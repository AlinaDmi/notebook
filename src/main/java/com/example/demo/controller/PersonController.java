package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.ContactService;
import com.example.demo.service.PersonService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final ContactService contactService;
    @GetMapping("/")
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @PostMapping
    public void createNewPerson(@RequestBody Person person){
        personService.createPerson(person);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long personId){
        contactService.deleteAllByPerson(personId);
        personService.deletePerson(personId);
    }
}
