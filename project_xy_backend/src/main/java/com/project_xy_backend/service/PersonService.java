package com.project_xy_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_xy_backend.dao.PersonRepository;
import com.project_xy_backend.model.Person;

@Service
public class PersonService{

  private final PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public List<Person> getAllPeople() {
    return personRepository.findAll();
  }

  public void addNewPerson(Person person) {
    if(personRepository.findPersonByEmail(person.getEmail()).isPresent()) {
      throw new IllegalStateException("email taken");
    }
    personRepository.save(person);
  }

}
