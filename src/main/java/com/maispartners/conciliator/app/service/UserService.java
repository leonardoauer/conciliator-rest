package com.maispartners.conciliator.app.service;

import com.maispartners.conciliator.app.model.User;
import com.maispartners.conciliator.core.service.IService;

public interface UserService extends IService<User>{

	User findByDetailedQuery(String firstName, Integer age);
}
