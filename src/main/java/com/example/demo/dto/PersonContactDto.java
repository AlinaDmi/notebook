package com.example.demo.dto;

import com.example.demo.entity.Person;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class PersonContactDto {
    Person person;
    List<ContactDto> contacts;
}
