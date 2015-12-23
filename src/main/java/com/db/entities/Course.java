package com.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Kenshinn on 12/23/2015 AD.
 */
@Entity
@Table(name = "COURSES")
public class Course extends AbstractEntity {

  @Column(name = "NAME")
  private String name;

  @ManyToMany(mappedBy = "courses")
  private List<Student> students;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

}
