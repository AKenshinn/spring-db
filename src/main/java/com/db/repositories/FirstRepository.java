package com.db.repositories;

import java.io.Serializable;

import com.db.entities.First;
import com.db.repositories.base.GenericDao;
import org.springframework.stereotype.Repository;

@Repository(value = "firstRepository")
public interface FirstRepository extends GenericDao<First, Serializable> {

}
