package com.example.demo.controller;

import com.example.demo.dto.ContactCreationDto;
import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;
    @GetMapping("/")
    public List<Contact> getContacts(){
        return contactService.getContacts();
    }

    @GetMapping(path = "{personId}")
    public List<Contact> getContactsForPerson(@PathVariable("personId") Long personId){
        return contactService.getContactsForPerson(personId);
    }

    @PostMapping
    public void createNewContact(@RequestBody ContactCreationDto dto){
        contactService.createContact(dto);
    }

    @DeleteMapping(path = "{contactId}")
    public void deleteContact(@PathVariable("contactId") Long contactId){
        contactService.deleteContact(contactId);
    }
}
