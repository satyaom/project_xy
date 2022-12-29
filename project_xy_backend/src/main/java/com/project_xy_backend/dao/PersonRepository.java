package com.project_xy_backend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project_xy_backend.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
  @Query("SELECT s FROM Person s WHERE s.email = ?1")
  Optional<Person> findPersonByEmail(String email);

  //Can be used to update table for patch or put request
  @Modifying
  @Query("UPDATE Person s SET s.name = :newPersonName WHERE s.id = :id")
  void updatedPeson(@Param("id") Long id, @Param("newPersonName") String newPersonName);
}
