package com.db.services.Impl;

import com.db.entities.Course;
import com.db.repositories.CourseRepository;
import com.db.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Kenshinn on 12/30/2015 AD.
 */
@Service(value = "courseService")
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Override
  public Serializable insert(Course course) {
    return courseRepository.insert(course);
  }

  @Override
  public void update(Course course) {
    courseRepository.update(course);
  }

  @Override
  public void delete(Course course) {
    courseRepository.delete(course);
  }

  @Override
  public void deleteById(Serializable serializable) {
    courseRepository.deleteById(serializable);
  }

  @Override
  public List<Course> findAll() {
    return courseRepository.findAll();
  }

  @Override
  public Course findById(Serializable serializable) {
    return courseRepository.findById(serializable);
  }

  @Override
  public List<Course> search(Map<String, Object> parameterMap) {
    return courseRepository.search(parameterMap);
  }

}
