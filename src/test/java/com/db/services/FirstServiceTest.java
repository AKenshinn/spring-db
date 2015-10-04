package com.db.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.db.entities.First;
import com.db.repositories.FirstRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@TransactionConfiguration
@Transactional
public class FirstServiceTest {

	@Autowired
	private FirstService firstService;
	
	private First first;
	
	@Before
	public void setUp() throws Exception {
		first = new First();
		first.setName("newFirst");
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadFirstServiceShouldPass() throws Exception {
		assertNotNull(firstService);
	}
	
	@Test
	public void testInsertShouldReturnThatObject() throws Exception {
		
		Serializable insertId = firstService.insert(first);
		First result = firstService.findById(insertId);
		assertThat(result.getName(), is("newFirst"));
	}
}



















