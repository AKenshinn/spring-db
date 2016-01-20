package com.db.repositories.impl;

import com.db.entities.Teacher;
import com.db.repositories.TeacherRepository;
import com.db.repositories.base.HibernateDAOImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Kenshinn on 12/29/2015 AD.
 */
@SuppressWarnings("unchecked")
@Repository(value = "teacherRepository")
public class TeacherRepositoryImpl extends HibernateDAOImpl<Teacher, Serializable> implements TeacherRepository {

}
