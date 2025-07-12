package com.hr.managemnt.controller;

import com.hr.managemnt.model.Person;
import com.hr.managemnt.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @GetMapping("/eyeColor/{color}")
    public List<Person> findByEyeColor(@PathVariable String color) {
        return repository.findByEyeColor(color);
    }
}
