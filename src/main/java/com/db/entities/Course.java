package com.db.entities;

import com.db.entities.base.AbstractEntity;

import javax.persistence.*;
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

  @ManyToOne
  @JoinColumn(name = "TEACHER_ID", nullable = false)
  private Teacher teacher;

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

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

}
