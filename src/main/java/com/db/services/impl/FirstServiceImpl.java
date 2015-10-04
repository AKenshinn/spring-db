package com.db.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.entities.First;
import com.db.repositories.FirstRepository;
import com.db.services.FirstService;

@Service(value="firstService")
public class FirstServiceImpl implements FirstService {

	@Autowired
	private FirstRepository firstRepository;
	
	@Override
	public Serializable insert(First entity) {
		return firstRepository.insert(entity);
	}

	@Override
	public void update(First entity) {
		firstRepository.update(entity);
	}

	@Override
	public void delete(First entity) {
		firstRepository.delete(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		firstRepository.deleteById(id);
	}

	@Override
	public List<First> findAll() {
		return firstRepository.findAll();
	}

	@Override
	public First findById(Serializable id) {
		return firstRepository.findById(id);
	}

	@Override
	public List<First> search(Map<String, Object> parameterMap) {
		return firstRepository.search(parameterMap);
	}
}
