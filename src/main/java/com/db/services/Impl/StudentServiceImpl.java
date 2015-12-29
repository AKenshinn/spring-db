package com.db.services.Impl;

import com.db.entities.Student;
import com.db.repositories.StudentRepository;
import com.db.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Kenshinn on 12/29/2015 AD.
 */
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Serializable insert(Student student) {
    return studentRepository.insert(student);
  }

  @Override
  public void update(Student student) {
    studentRepository.update(student);
  }

  @Override
  public void delete(Student student) {
    studentRepository.delete(student);
  }

  @Override
  public void deleteById(Serializable serializable) {
    studentRepository.deleteById(serializable);
  }

  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  @Override
  public Student findById(Serializable serializable) {
    return studentRepository.findById(serializable);
  }

  @Override
  public List<Student> search(Map<String, Object> parameterMap) {
    return studentRepository.search(parameterMap);
  }

}
