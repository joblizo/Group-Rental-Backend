package com.skillstorm.rentalweb.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.rentalweb.models.Car;
import com.skillstorm.rentalweb.repositories.CarRepository;

@Service
@Transactional
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository repository;

	@Override
	public Iterable<Car> findAll() {
		return repository.findAll();
	}

	@Override
	public Car findByLicense(String license) {
		Optional<Car> car = Optional.ofNullable(repository.findByLicense(license));
		return car.isPresent() ? car.get() : null;
	}

	@Override
	public Car save(Car car) {
		return repository.save(car);
	}

	@Override
	public Car update(Car car) {
		return repository.save(car);
	}

	@Override
	public List<Car> deleteByLicense(String license) {
		return repository.deleteByLicense(license);
	}

}
