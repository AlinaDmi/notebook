package com.example.demo.controller;

import com.example.demo.dto.PersonContactDto;
import com.example.demo.entity.Person;
import com.example.demo.service.NotebookService;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/notebook")
@RequiredArgsConstructor
public class NoteController {
    private final NotebookService service;
    @GetMapping("/")
    public List<PersonContactDto> getPeopleWithContacts(){
        return service.getPeopleWithContacts();
    }
}
