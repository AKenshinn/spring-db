package com.db.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.db.entities.Course;
import com.db.entities.Teacher;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kenshinn on 12/23/2015 AD.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TransactionConfiguration
@Transactional
public class CourseRepositoryTest {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private TeacherRepository teacherRepository;

  private Course english, math;

  private Teacher poonna, panupat;

  @Before
  public void setUp() throws Exception {
    panupat = new Teacher();
    panupat.setFirstName("Panupat");
    panupat.setLastName("Horma");
    teacherRepository.insert(panupat);

    poonna = new Teacher();
    poonna.setFirstName("Poonna");
    poonna.setLastName("Yospanya");
    teacherRepository.insert(poonna);

    english = new Course();
    english.setName("English");
    english.setTeacher(poonna);
    courseRepository.insert(english);

    math = new Course();
    math.setName("Math");
    math.setTeacher(panupat);
    courseRepository.insert(math);

  }

  @Test
  public void testLoadCourseRepositoryTestShouldPass() throws Exception {
    assertNotNull(courseRepository);
  }

  @Test
  public void testLoadTeacherRepositoryShouldPass() throws Exception {
    assertNotNull(teacherRepository);
  }

  @Test
  public void testFindByIdWithCourseRepositoryShouldReturnCourseThatSetup() throws Exception {
    Course result = courseRepository.findById(english.getId());
    assertNotNull(result);
    assertThat(result.getName(), is(("English")));
    assertThat(result.getTeacher().getFirstName(), is("Poonna"));

  }

  @Test
  public void testFindAllWithCourseRepositoryShouldReturnListOfAllCourses() throws Exception {
    List<Course> result = courseRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(2)));

  }

  @Test
  public void testUpdateWithCourseRepositoryShouldChangeMathToProgramming() throws Exception {
    Course update = courseRepository.findById(math.getId());
    update.setName("Programming");
    courseRepository.update(update);

    Course result = courseRepository.findById(update.getId());
    assertNotNull(result);
    assertThat(result.getName(), is("Programming"));

  }

  @Test
  public void testDeleteWithCourseRepositoryShouldNotFindEnglish() throws Exception {
    Course delete = courseRepository.findById(english.getId());
    courseRepository.delete(delete);

    Course result = courseRepository.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithCourseRepositoryShouldNotFindEnglish() throws Exception {
    Course delete = courseRepository.findById(english.getId());
    courseRepository.deleteById(delete.getId());

    Course result = courseRepository.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testSearchWithCourseRepositoryShouldFindEnglish() throws Exception {
    HashMap<String, Object> parameterMap = new HashMap<>();
    parameterMap.put("name", english.getName());

    List<Course> result = courseRepository.search(parameterMap);
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("English"));

  }

}
