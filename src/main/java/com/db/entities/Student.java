package com.db.entities;

import com.db.entities.base.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kenshinn on 12/23/2015 AD.
 */
@Entity
@Table(name = "STUDENTS")
public class Student  extends AbstractEntity {

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @JsonIgnore
  @ManyToMany
  @JoinTable(name="STUDENT_COURSE",
    joinColumns={ @JoinColumn(name="STUDENT_ID", nullable=false) },
    inverseJoinColumns={ @JoinColumn(name="COURSE_ID", nullable=false) }
  )
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
