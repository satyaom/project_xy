package com.project_xy_backend.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Person{
    @Id
    @SequenceGenerator(
      name = "person_generator",
      sequenceName = "person_sequence",
      allocationSize = 1
    )
    @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator =  "person_sequence"
    )

    private Long id;
    @NotBlank(message = "Field name must not be blank")
    private String name;
    private LocalDate dob;
    @Email
    private String email;
    @Transient
    private Integer age;

    public Person() {}
    
    public Person(@JsonProperty("name") String name, @JsonProperty("dob") LocalDate dob, @JsonProperty("email") String email) {
      this.name = name;
      this.dob = dob;
      this.email = email;
    }

    public String getEmail() {
      return email;
    }
    public LocalDate getDate() {
      return dob;
    }
    public Integer getAge() {
      return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public String getName(){
        return name;
    }
    public Long getId() {
        return id;
    }
    public void setAge(Integer age) {
      this.age = age;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public void setDob(LocalDate dob) {
      this.dob = dob;
    }
    public void setName(String name) {
      this.name = name;
    }

}
