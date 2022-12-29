package com.project_xy_backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project_xy_backend.dao.PersonRepository;
import com.project_xy_backend.model.Person;

@Service
public class PersonService{

  private final PersonRepository personRepository;

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

  @Transactional
  public void deletePerson(Long id) {
    if(personRepository.findById(id).isPresent()) {
      personRepository.deleteById(id);
    } else {
      throw new IllegalAccessError("wrong id");
    }
  }

  @Transactional
  public void updatePerson(Long id, String newPersonName) {
    Optional<Person> oldPerson = personRepository.findById(id);
    if(oldPerson.isPresent()){
      System.out.println(newPersonName);
      oldPerson.get().setName(newPersonName);
     } else {
      throw new IllegalAccessError("wrong id");
     }
  }

}
