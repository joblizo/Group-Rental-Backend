package com.skillstorm.rentalweb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skillstorm.rentalweb.models.AvailableCarsForm;
import com.skillstorm.rentalweb.models.Car;
import com.skillstorm.rentalweb.models.ReservationsByEmailForm;
import com.skillstorm.rentalweb.models.User;
import com.skillstorm.rentalweb.models.UserReservation;
import com.skillstorm.rentalweb.tools.CarJustRentedException;

@Service
@Transactional
public interface UserReservationService {

	public Iterable<UserReservation> findAll();
	//Find by Reservation ID
	public UserReservation findById(int id);
	//Find by User ID
	public List<UserReservation> findByUser(User user);
	public UserReservation save(UserReservation userReservation) throws CarJustRentedException;
	public UserReservation update(UserReservation userReservation);
	public List<UserReservation> deleteById(int Licidense);
	public List<UserReservation>getReservationByEmail(ReservationsByEmailForm reservationsByEmailForm);
	
	public List<Car> getAvailableCars(AvailableCarsForm availableCarsForm);
	public List<String> filterCarsByDateRange(List<String> cars, int startDate, int endDate);
	public List<String> getUnreservedCars(List<String> licenses);
}
