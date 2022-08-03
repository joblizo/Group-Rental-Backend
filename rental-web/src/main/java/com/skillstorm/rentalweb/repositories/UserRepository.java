package com.skillstorm.rentalweb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.rentalweb.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	List<User> deleteById(int id);
	User findByEmail(String email);
}
