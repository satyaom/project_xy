package com.project_xy_backend.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project_xy_backend.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertPerson(UUID id, Person person) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<Person> selectAllPeople() {
    final String sql = "select id, name from person";
     List<Person> people = jdbcTemplate.query(sql, (rs, i) -> {
        UUID id = UUID.fromString(rs.getString("id"));
        String name = rs.getString("name");
        return new Person(id, name);
      });
      return people;
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    final String sql = "select id, name from person where id = ?";
    Person person = jdbcTemplate.queryForObject(sql, (rs, i) -> {
      UUID person_id = UUID.fromString(rs.getString("id"));
      String name = rs.getString("name");
      return new Person(person_id, name);
    }, new Object[]{id});
    return Optional.ofNullable(person);
  }

  @Override
  public int deletePersonById(UUID id) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    // TODO Auto-generated method stub
    return 0;
  }
  
}
