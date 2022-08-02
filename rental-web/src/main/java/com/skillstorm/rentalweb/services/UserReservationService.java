package com.skillstorm.rentalweb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skillstorm.rentalweb.models.AvailableCarsForm;
import com.skillstorm.rentalweb.models.Car;
import com.skillstorm.rentalweb.models.UserReservation;

@Service
@Transactional
public interface UserReservationService {

	public Iterable<UserReservation> findAll();
	public UserReservation findById(int id);
	public UserReservation save(UserReservation userReservation);
	public UserReservation update(UserReservation userReservation);
	public List<UserReservation> deleteById(int Licidense);
	
	public List<Car> getAvailableCars(AvailableCarsForm availableCarsForm);
	public List<String> filterCarsByDateRange(List<String> cars, int startDate, int endDate);
	public List<String> getUnreservedCars(List<String> licenses);
}
