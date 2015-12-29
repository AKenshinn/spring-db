package com.db.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by Kenshinn on 12/23/2015 AD.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TransactionConfiguration
public class CourseRepositoryTest {

  @Autowired
  private CourseRepository courseRepository;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testLoadCourseRepositoryTestShouldPass() throws Exception {
    assertNotNull(courseRepository);
  }
}
