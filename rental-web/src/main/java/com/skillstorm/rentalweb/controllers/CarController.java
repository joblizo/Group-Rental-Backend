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

import com.skillstorm.rentalweb.models.Car;
import com.skillstorm.rentalweb.services.CarService;

@RestController
@RequestMapping("/cars")
@CrossOrigin("*")
public class CarController {
	
	@Autowired
	private CarService service;
	
	//find all
	@GetMapping()
	public Iterable<Car> findAll(){
		return service.findAll();		
	}

	//find by id
	@GetMapping("/{license}")
	public Car findbyLicense(@PathVariable String license){
		return service.findByLicense(license);
	}
	
	@PostMapping
	public Car create(@Valid @RequestBody Car car) {
		return service.save(car);
	}
	
	@PutMapping
	public Car update(@Valid @RequestBody Car car) {
		return service.save(car);
	}
	
	@DeleteMapping("/{license}")
	public List<Car> deleteByLicense(@Valid @PathVariable String license) {
		return service.deleteByLicense(license);
	}



}
