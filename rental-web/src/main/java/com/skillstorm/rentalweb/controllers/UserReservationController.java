package com.skillstorm.rentalweb.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.skillstorm.rentalweb.models.AvailableCarsForm;
import com.skillstorm.rentalweb.models.Car;
import com.skillstorm.rentalweb.models.ReservationsByEmailForm;
import com.skillstorm.rentalweb.models.UserReservation;
import com.skillstorm.rentalweb.services.UserReservationService;
import com.skillstorm.rentalweb.tools.CarJustRentedException;

@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class UserReservationController {
	
	@Autowired
	UserReservationService service;
	
		//find all
		@GetMapping()
		public Iterable<UserReservation> findAll(){
			return service.findAll();		
		}

		//find by reservation id
		@GetMapping("/{id}")
		public UserReservation findbyId(@PathVariable int id){
			return service.findById(id);
		}
	
		@GetMapping("/cars/{capacity}/{sDate}/{eDate}")
		public List<Car> getAvailableCars(@PathVariable @NotBlank int capacity, @PathVariable @NotBlank int sDate, @PathVariable @NotBlank int eDate ){
			AvailableCarsForm availableCarsForm = new AvailableCarsForm(capacity, sDate, eDate);
			return service.getAvailableCars(availableCarsForm);
		}
		
		//find reservations by email
		@GetMapping("/user/{email}")
		public List<UserReservation> getReservationByEmail(@PathVariable @NotBlank String email){
			ReservationsByEmailForm reservationsByEmailForm = new ReservationsByEmailForm(email);
			return service.getReservationByEmail(reservationsByEmailForm);
		}
		
		@PostMapping
		public UserReservation create(@Valid @RequestBody UserReservation userReservation) {
			try {
				return service.save(userReservation);
			} catch (CarJustRentedException e) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
			}
		}
		
		@PutMapping
		public UserReservation update(@Valid @RequestBody UserReservation userReservation) {
			try {
				return service.save(userReservation);
			} catch (CarJustRentedException e) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
			}
		}
		
		@DeleteMapping("/{id}")
		public List<UserReservation> deleteByLicense(@Valid @PathVariable int id) {
			return service.deleteById(id);
		}

}
