package com.db.services.Impl;

import com.db.entities.Teacher;
import com.db.repositories.TeacherRepository;
import com.db.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Kenshinn on 12/30/2015 AD.
 */
@Service(value = "teacherService")
public class TeacherServiceImpl implements TeacherService {

  @Autowired
  private TeacherRepository teacherRepository;

  @Override
  public Serializable insert(Teacher teacher) {
    return teacherRepository.insert(teacher);
  }

  @Override
  public void update(Teacher teacher) {
    teacherRepository.update(teacher);
  }

  @Override
  public void delete(Teacher teacher) {
    teacherRepository.delete(teacher);
  }

  @Override
  public void deleteById(Serializable serializable) {
    teacherRepository.deleteById(serializable);
  }

  @Override
  public List<Teacher> findAll() {
    return teacherRepository.findAll();
  }

  @Override
  public Teacher findById(Serializable serializable) {
    return teacherRepository.findById(serializable);
  }

  @Override
  public List<Teacher> search(Map<String, Object> parameterMap) {
    return teacherRepository.search(parameterMap);
  }

}
