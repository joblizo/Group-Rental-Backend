package com.skillstorm.rentalweb.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.rentalweb.models.UserReservation;
import com.skillstorm.rentalweb.repositories.UserReservationRepository;

@Service
@Transactional
public class UserReservationServiceImpl implements UserReservationService{

	
	@Autowired
	private UserReservationRepository repository;
	
	@Override
	public Iterable<UserReservation> findAll() {
		return repository.findAll();
	}

	@Override
	public UserReservation findById(int id) {
		Optional<UserReservation> userReservation = repository.findById(id);
		return userReservation.isPresent() ? userReservation.get() : null;
	}

	@Override
	public UserReservation save(UserReservation userReservation) {
		return repository.save(userReservation);
	}

	@Override
	public UserReservation update(UserReservation userReservation) {
		return repository.save(userReservation);
	}

	@Override
	public List<UserReservation> deleteById(int id) {
		return repository.deleteById(id);
	}

}
