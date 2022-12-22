package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    public List<Person> getPeople(){
        return personRepository.findAll();
    }

    public void createPerson(Person person) {
        if (personRepository.findPersonByName(person.getName()).isPresent()){
            throw new IllegalStateException("person already exists");
        }
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        personRepository.findById(personId).ifPresent(personRepository::delete);
    }

    public Person getById(Long id){
        return personRepository.findById(id).orElse(null);
    }
}
