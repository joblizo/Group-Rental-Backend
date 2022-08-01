package com.skillstorm.rentalweb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.rentalweb.models.User;
import com.skillstorm.rentalweb.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	//find all
	@GetMapping()
	public Iterable<User> findAll(){
		return service.findAll();		
	}

	//find by id
	@GetMapping("/{id}")
	public User findbyId(@PathVariable int id){
		return service.findById(id);
	}
	
	@PostMapping
	public User create(@Valid @RequestBody User user) {
		System.err.println(user);
		return service.save(user);
	}
	
	@PutMapping
	public User update(@Valid @RequestBody User user) {
		return service.save(user);
	}
	
	@DeleteMapping("/{id}")
	public List<User> deleteByLicense(@Valid @PathVariable int id) {
		return service.deleteById(id);
	}
}
