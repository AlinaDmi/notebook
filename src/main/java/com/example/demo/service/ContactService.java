package com.example.demo.service;

import com.example.demo.dto.ContactCreationDto;
import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository repository;
    private final PersonService personService;
    public List<Contact> getContactsForPerson(Long personId){
        return repository.findAllByPersonId(personId);
    }
    public List<Contact> getContacts(){
        return repository.findAll();
    }

    public void createContact(ContactCreationDto dto) {
        val person = personService.getById(dto.getPersonId());
        if (person==null){
            throw new IllegalStateException("person not exist");
        }
        val personContacts = repository.findAllByPersonId(dto.getPersonId());
        if (personContacts.stream().anyMatch(c -> c.getPersonContact().equals(dto.getContact()))){
            throw new IllegalStateException("person contact already exists");
        }
        repository.save(new Contact(null,person, dto.getContact()));
    }

    public void deleteContact(Long contactId) {
        repository.findById(contactId).ifPresent(repository::delete);
    }
    public void deleteAllByPerson(Long personId) {
        repository.deleteAll(repository.findAllByPersonId(personId));
    }
}
