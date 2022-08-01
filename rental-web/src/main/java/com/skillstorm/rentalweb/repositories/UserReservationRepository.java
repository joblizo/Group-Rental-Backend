package com.skillstorm.rentalweb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.rentalweb.models.UserReservation;

@Repository
public interface UserReservationRepository extends CrudRepository<UserReservation, Integer>{
	List<UserReservation> deleteById(int id);
}
