package com.project_xy_backend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project_xy_backend.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
  @Query("SELECT s FROM Person s WHERE s.email = ?1")
  Optional<Person> findPersonByEmail(String email);
}
