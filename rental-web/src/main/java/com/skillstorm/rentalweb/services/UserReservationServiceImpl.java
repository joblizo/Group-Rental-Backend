package com.skillstorm.rentalweb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.rentalweb.models.AvailableCarsForm;
import com.skillstorm.rentalweb.models.Car;
import com.skillstorm.rentalweb.models.ReservationsByEmailForm;
import com.skillstorm.rentalweb.models.User;
import com.skillstorm.rentalweb.models.UserReservation;
import com.skillstorm.rentalweb.repositories.CarRepository;
import com.skillstorm.rentalweb.repositories.UserRepository;
import com.skillstorm.rentalweb.repositories.UserReservationRepository;
import com.skillstorm.rentalweb.tools.CarJustRentedException;

@Service
@Transactional
public class UserReservationServiceImpl implements UserReservationService{
	@Autowired
	private UserReservationRepository userReservationRepository;
	
	@Autowired 
	private CarRepository carRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public Iterable<UserReservation> findAll() {
		return userReservationRepository.findAll();
	}

	//Find by Reservation ID
	@Override
	public UserReservation findById(int id) {
		Optional<UserReservation> userReservation = userReservationRepository.findById(id);
		return userReservation.isPresent() ? userReservation.get() : null;
	}
	
	//Find by Reservation ID
	@Override
	public List<UserReservation> findByUser(User user) {
		List<UserReservation> userReservations = userReservationRepository.findByUser(user);
		return userReservations.isEmpty() ? null : userReservations;
	}

	@Override
	public UserReservation save(UserReservation userReservation) throws CarJustRentedException {
		//Validate if car is still available
		Car car = userReservation.getCar();
		System.out.println("Dates: " + userReservation.getrStart() + " " + userReservation.getrEnd());
		AvailableCarsForm availableCarsForm = new AvailableCarsForm(car.getCapacity(), userReservation.getrStart(), userReservation.getrEnd());
		
		List<Car> availableCars = getAvailableCars(availableCarsForm);
		System.out.println("Available cars: " + availableCars);
		if(availableCars.contains(car)){
			return userReservationRepository.save(userReservation);
		}
		
		CarJustRentedException ex = new CarJustRentedException("Car was just rented by another user. Sorry!");
		throw ex;
	}

	@Override
	public UserReservation update(UserReservation userReservation) {
		return userReservationRepository.save(userReservation);
	}

	@Override
	public List<UserReservation> deleteById(int id) {
		return userReservationRepository.deleteById(id);
	}
	
	public List<UserReservation>getReservationByEmail(ReservationsByEmailForm reservationsByEmailForm){
		User user = userRepository.findByEmail(reservationsByEmailForm.getEmail());		
		return userReservationRepository.findByUser(user);
	}

	public List<Car> findByCapacityGreaterThanEqual(int capacity) {
		return carRepository.findByCapacityGreaterThanEqual(capacity);
	}
	
	@Override
	public List<Car> getAvailableCars(AvailableCarsForm availableCarsForm) {
		//Filter cars by capacity TODO: Could refactor this to only get licenses so that we can remove the for each loop after
		List<Car> cars = findByCapacityGreaterThanEqual(availableCarsForm.getCapacity());
		
		//Get licenses of cars
		List<String> licenses = new ArrayList<String>();
		for(Car car : cars)
		{
			licenses.add(car.getLicense());
		}
		
		//Filter available cars by date range
		List<String> availableCars = filterCarsByDateRange(licenses, availableCarsForm.getStartDate(), availableCarsForm.getEndDate());
		
		//Get unreserved, with same capacity cars, assuming that they're available.
		List<String> unreservedCars = userReservationRepository.getUnreservedCars(licenses);
		
		for(String car : unreservedCars)
		{
			availableCars.add(car);
		}
		
		return carRepository.findByLicenseIn(availableCars);
	}

	public List<String> filterCarsByDateRange(List<String> cars, int startDate, int endDate) {
		return userReservationRepository.filterCarsByDateRange(cars,startDate,endDate);
	}
	
	public List<String> getUnreservedCars(List<String> licenses){
		return userReservationRepository.getUnreservedCars(licenses);
	}
	
	
}
