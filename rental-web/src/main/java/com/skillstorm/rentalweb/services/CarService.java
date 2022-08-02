package com.skillstorm.rentalweb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skillstorm.rentalweb.models.Car;

@Service
@Transactional
public interface CarService {

	public Iterable<Car> findAll();
	public Car findByLicense(String License);
	public Car save(Car car);
	public Car update(Car car);
	public List<Car>  deleteByLicense(String License);
}
