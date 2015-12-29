package com.db.repositories.impl;

import com.db.entities.Course;
import com.db.repositories.CourseRepository;
import com.db.repositories.base.HibernateDAOImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Kenshinn on 12/29/2015 AD.
 */
@Repository(value = "courseRepository")
public class CourseRepositoryImpl extends HibernateDAOImpl<Course, Serializable> implements CourseRepository {

}
