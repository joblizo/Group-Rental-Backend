package com.skillstorm.rentalweb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
		try {
			return service.save(user);
		}
		catch(DataIntegrityViolationException  e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Email:%s already in use. Please use another email.", user.getEmail()));
		}
		
	}
	
	@PutMapping
	public User update(@Valid @RequestBody User user) {
		try {
			return service.save(user);
		}
		catch(DataIntegrityViolationException  e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Email:%s already in use. Please use another email.", user.getEmail()));
		}
	}
	
	@DeleteMapping("/{id}")
	public List<User> deleteByLicense(@Valid @PathVariable int id) {
		return service.deleteById(id);
	}
}
