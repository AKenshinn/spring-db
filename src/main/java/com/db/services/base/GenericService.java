package com.db.services.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericService<Entity, ID extends Serializable> {

	ID insert(Entity entity);
	
	void update(Entity entity);
	
	void delete(Entity entity);
	
	void deleteById(ID id);
	
	List<Entity> findAll();
	
	Entity findById(ID id);
		
	List<Entity> search(Map<String, Object> parameterMap);
}
