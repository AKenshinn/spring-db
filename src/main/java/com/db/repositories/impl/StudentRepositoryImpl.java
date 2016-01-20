package com.db.repositories.impl;

import com.db.entities.Student;
import com.db.repositories.StudentRepository;
import com.db.repositories.base.HibernateDAOImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Kenshinn on 12/29/2015 AD.
 */
@SuppressWarnings("unchecked")
@Repository(value = "studentRepository")
public class StudentRepositoryImpl extends HibernateDAOImpl<Student, Serializable> implements StudentRepository {

}
