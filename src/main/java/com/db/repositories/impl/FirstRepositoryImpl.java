package com.db.repositories.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.db.entities.First;
import com.db.repositories.FirstRepository;
import com.db.repositories.base.HibernateDAOImpl;

@Repository(value="firstRepository")
public class FirstRepositoryImpl extends HibernateDAOImpl<First, Serializable> implements FirstRepository {

}
