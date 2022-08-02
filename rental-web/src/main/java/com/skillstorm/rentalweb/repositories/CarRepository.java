package com.skillstorm.rentalweb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.skillstorm.rentalweb.models.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String>{
	Car findByLicense(String license);
	List<Car> deleteByLicense(String license);
	List<Car> findByCapacity(int capacity);
	List<Car> findByLicenseIn(List<String> licenses);
}
