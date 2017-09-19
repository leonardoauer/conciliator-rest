package com.maispartners.conciliator.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maispartners.conciliator.app.model.User;
import com.maispartners.conciliator.core.repository.Repository;

public interface UserRepository extends Repository<User> {
	
	@Query("SELECT u FROM User u WHERE u.firstName = :firstName AND u.age = :age AND u.active = 0")
	User findByDetailedQuery(@Param("firstName") String firstName, @Param("age") Integer age);
}
