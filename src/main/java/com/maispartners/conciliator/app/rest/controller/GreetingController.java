package com.maispartners.conciliator.app.rest.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maispartners.conciliator.app.model.Greeting;
import com.maispartners.conciliator.app.model.User;
import com.maispartners.conciliator.app.service.UserJdbcService;
import com.maispartners.conciliator.app.service.UserService;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserJdbcService userJdbcService;
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/greeting/jpa")
	public List<User> jpa() {
		
		User user = new User();
		user.setFirstName("Leonardo");
		user.setLastName("Auer");
		user.setAge(40);
		user.setCreationDate(new Date());
		user.setModificationDate(new Date());
		user.setActive(true);
		
		userService.save(user);
		return userService.findAll();
	}
	
	@RequestMapping("/greeting/jpa/byquery")
	public User byquery() {
		return userService.findByDetailedQuery("Leonardo", 40);
	}

	@RequestMapping("/greeting/jdbc")
	public User jdbc() {
		
		User user = new User();
		user.setFirstName("Leonardo");
		user.setLastName("Auer");
		user.setAge(40);
		user.setCreationDate(new Date());
		user.setModificationDate(new Date());
		user.setActive(true);
		
		User savedUser = userService.save(user);
		return userJdbcService.findOne(savedUser.getId());
	}
}
