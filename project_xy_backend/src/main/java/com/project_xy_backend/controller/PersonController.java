package com.project_xy_backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_xy_backend.model.Person;
import com.project_xy_backend.service.PersonService;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
  
  private PersonService personService;

  public PersonController(PersonService personService){
    this.personService = personService;
  }

  @GetMapping
  public List<Person> getAllPeople(){
    return personService.getAllPeople();
  }

  @PostMapping
  public void addNewPerson(@RequestBody @Valid Person person) {
    personService.addNewPerson(person);
  }
}
