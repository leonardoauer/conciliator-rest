package com.maispartners.conciliator.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maispartners.conciliator.app.model.User;
import com.maispartners.conciliator.app.repository.jdbc.UserJdbcRepository;
import com.maispartners.conciliator.core.service.jdbc.CrudJdbcService;

@Service
@Transactional
public class UserJdbcServiceImpl extends CrudJdbcService<User> implements UserJdbcService {

	@Autowired
	private UserJdbcRepository userJdbcRepository;
	
	@Override
	protected UserJdbcRepository getJdbcRepository() {
		return userJdbcRepository;
	}
}
