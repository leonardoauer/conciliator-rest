package com.maispartners.conciliator.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maispartners.conciliator.app.model.User;
import com.maispartners.conciliator.app.repository.UserRepository;
import com.maispartners.conciliator.app.repository.jdbc.UserJdbcRepository;
import com.maispartners.conciliator.core.service.CrudService;

@Service
@Transactional
public class UserServiceImpl extends CrudService<User> implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserJdbcRepository userJdbcRepository;

	@Override
	public User findByDetailedQuery(String firstName, Integer age) {
		return userRepository.findByDetailedQuery(firstName, age);
	}

	@Override
	public User findOne(Long id) {
		return userJdbcRepository.findOne(id);
	}

	@Override
	public User save(User entity) {
		return userJdbcRepository.save(entity);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
