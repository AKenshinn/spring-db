package com.db.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.db.entities.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Kenshinn on 12/29/2015 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
@TransactionConfiguration
@Transactional
public class TeacherRepositoryTest {

  @Autowired
  private TeacherRepository teacherRepository;

  private Teacher papupat, poonna;

  @Before
  public void setUp() throws Exception {
    papupat = new Teacher();
    papupat.setFirstName("Panupat");
    papupat.setLastName("Horma");
    teacherRepository.insert(papupat);

    poonna = new Teacher();
    poonna.setFirstName("Poonna");
    poonna.setLastName("Yospanya");
    teacherRepository.insert(poonna);

  }

  @Test
  public void testLoadTeacherRepositoryShouldPass() throws Exception {
    assertNotNull(teacherRepository);
  }

  @Test
  public void testFindByIdWithTeacherRepositoryShouldReturnTeacherThatSetup() throws Exception {
    Teacher result = teacherRepository.findById(papupat.getId());
    assertNotNull(result);
    assertThat(result.getId(), is(papupat.getId()));
    assertThat(result.getFirstName(), is("Panupat"));
    assertThat(result.getLastName(), is("Horma"));
    
  }

  @Test
  public void testFindAllWithTeacherRepositoryShouldReturnListOfAllTeacher() throws Exception {
    List<Teacher> result = teacherRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual(2)));
    
  }

  @Test
  public void testUpdateWithTeacherRepositoryShouldChangePanupatToHimura() throws Exception {
    Teacher update = teacherRepository.findById(papupat.getId());
    update.setFirstName("Himura");
    teacherRepository.update(update);

    Teacher result = teacherRepository.findById(update.getId());
    assertNotNull(result);
    assertThat(result.getFirstName(), is("Himura"));

  }

  @Test
  public void testDeleteWithTeacherRepositoryShouldNotFindPanupat() throws Exception {
    Teacher delete = teacherRepository.findById(papupat.getId());
    teacherRepository.delete(delete);

    Teacher result = teacherRepository.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithTeacherRepositoryShouldNotFindPanupat() throws Exception {
    Teacher delete = teacherRepository.findById(papupat.getId());
    teacherRepository.deleteById(delete.getId());

    Teacher result = teacherRepository.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testSearchWithStudentRepositoryShouldFindAnat() throws Exception {
    HashMap<String, Object> parameterMap = new HashMap<>();
    parameterMap.put("firstName", papupat.getFirstName());
    parameterMap.put("lastName", papupat.getLastName());

    List<Teacher> result = teacherRepository.search(parameterMap);
    assertNotNull(result);
    assertThat(result.get(0).getFirstName(), is("Panupat"));
    assertThat(result.get(0).getLastName(), is("Horma"));

  }

}
