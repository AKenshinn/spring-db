package com.db.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.db.entities.Student;
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
public class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  private Student anat, akkhawat;

  @Before
  public void setUp() throws Exception {
    anat = new Student();
    anat.setFirstName("Anat");
    anat.setLastName("Abdullagasim");
    studentRepository.insert(anat);

    akkhawat = new Student();
    akkhawat.setFirstName("Akkhawat");
    akkhawat.setLastName("Dilokchalermkul");
    studentRepository.insert(akkhawat);

  }

  @Test
  public void testLoadStudentRepositoryShouldPass() throws Exception {
    assertNotNull(studentRepository);
  }

  @Test
  public void testFindByIdWithStudentRepositoryShouldReturnStudentThatSetup() throws Exception {
    Student result = studentRepository.findById(anat.getId());
    assertNotNull(result);
    assertThat(result.getId(), is(anat.getId()));
    assertThat(result.getFirstName(), is("Anat"));
    assertThat(result.getLastName(), is("Abdullagasim"));

  }

  @Test
  public void testFindAllWithStudentRepositoryShouldReturnListOfAllStudent() throws Exception {
    List<Student> result = studentRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual(2)));

  }

  @Test
  public void testUpdateWithStudentRepositoryShouldChangeAnatToHimura() throws Exception {
    Student update = studentRepository.findById(anat.getId());
    update.setFirstName("Himura");
    studentRepository.update(update);

    Student result = studentRepository.findById(update.getId());
    assertThat(result.getId(), is(anat.getId()));
    assertThat(result.getFirstName(), is("Himura"));

  }

  @Test
  public void testDeleteWithStudentRepositoryShouldNotFindAnat() throws Exception {
    Student delete = studentRepository.findById(anat.getId());
    studentRepository.delete(delete);

    Student result = studentRepository.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithStudentRepositoryShouldNotFindAkkhawat() throws Exception {
    Student delete = studentRepository.findById(akkhawat.getId());
    studentRepository.deleteById(delete.getId());

    Student result = studentRepository.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testSearchWithStudentRepositoryShouldFindAnat() throws Exception {
    HashMap<String, Object> parameterMap = new HashMap<>();
    parameterMap.put("firstName", anat.getFirstName());
    parameterMap.put("lastName", anat.getLastName());

    List<Student> result = studentRepository.search(parameterMap);
    assertNotNull(result);
    assertThat(result.get(0).getFirstName(), is("Anat"));
    assertThat(result.get(0).getLastName(), is("Abdullagasim"));

  }

}
