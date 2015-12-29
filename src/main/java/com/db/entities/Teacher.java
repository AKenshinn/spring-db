package com.db.entities;

import com.db.entities.base.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kenshinn on 12/29/2015 AD.
 */
@Entity
@Table(name = "TEACHERS")
public class Teacher extends AbstractEntity {

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @JsonIgnore
  @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
  private List<Course> courses;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

}
