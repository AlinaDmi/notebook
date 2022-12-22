package com.example.demo.service;

import com.example.demo.dto.ContactDto;
import com.example.demo.dto.PersonContactDto;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Person;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookService {
    private final PersonService personService;
    private final ContactService contactService;

    public List<PersonContactDto> getPeopleWithContacts() {
        val people = personService.getPeople();
        List<PersonContactDto> result = new ArrayList<>();
        for (Person person : people){
            val contacts = contactService.getContactsForPerson(person.getId());
            result.add(PersonContactDto.builder()
                    .person(person)
                    .contacts(getContactDto(contacts))
                    .build());
        }
        return result;
    }

    private List<ContactDto> getContactDto(List<Contact> contacts){
        List<ContactDto> result = new ArrayList<>();
        for (Contact contact : contacts){
            result.add(ContactDto.builder()
                    .contactId(contact.getId())
                    .personContact(contact.getPersonContact())
                    .build());
        }
        return result;
    }
}
