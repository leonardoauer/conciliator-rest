package com.maispartners.conciliator.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maispartners.conciliator.core.model.Bean;

public interface Repository<T extends Bean> extends CrudRepository<T, Long> {
	
	List<T> findAll();
}
